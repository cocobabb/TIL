참고: https://docs.spring.io/spring-framework/reference/web/websocket/stomp.html
https://docs.spring.io/spring-framework/reference/web/websocket/stomp/enable.html
: 메시지 포맷 형식이나 메시지 통신 과정 등의 번거로운 과정을 WebSocket을 대신해줄 수 있는 **STOMP**(Simple Text Oriented Messaging Protocol) 프로토콜을 서브 프로토콜로 사용
- 기본적으로 **Pub**(Publisher, 메세지 공급 객체) / **Sub**(Subscriber, 메세지 소비 객체) 구조임
- **Pub/Sub** 은 서로 **직접 통신하지 않고 `메시지 브로커(Message Broker)` 를 통해 Sub들에게 Pub의 메시지를 전달**
## Client
```javascript
// WebSocket과 연결
const socket = new SockJS('/portfolio');
const stompClient = Stomp.over(socket);

// WebSocket 서버로 메시지 전송
stompClient.send("/app/chat.send", {}, JSON.stringify({
	sender: "user1"
	content: "Hi! Nice meet you"
}));
```
## Spring
```java
@Configuration
//STOMP 프로토콜을 사용하는 WebSocket 메시징을 활성화
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// WebScoket으로 가기 위한 HTTP URL
		// 클라이언트가 WebSocket과의 연결을 할 때 쓰일 주소
		registry.addEndpoint("/portfolio");
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
	// 클라이언트가 WebSocket 서버로 메시지를 보낼 때 쓰일 주소
	// Controller의 @MessageMapping 어노테이션 붙은 메서드(매핑/app으로 시작)로 라우팅됨
		config.setApplicationDestinationPrefixes("/app");
		
	//서버 -> 클라이언트 구독
		config.enableSimpleBroker("/topic", "/queue");
	}
}
```
- 접두사 `/topic`와 `/queue`접두사는 특별한 의미가 없습니다. 이는 단순히 Pub-Sub과 Point-to-Point 메시징(즉, 여러 구독자와 단일 소비자)을 구분하기 위한 규칙일 뿐

- 외부 브로커(RabbitMQ, Redis, Kafka)를 사용하는 경우, 브로커의 STOMP 페이지를 확인하여 지원하는 STOMP 대상과 접두사의 종류를 확인할 것
	- `RabbitMQ`
		- AMQP 프로토콜 기반으로 복잡한 메시지 라우팅 (`Exchange`, `Queue`, `Routing Key`)을 매우 잘 처리하는 브로커
		- - 메시지를 JSON 등 복잡한 구조로 처리할 수 있으며, 처리 실패 시 재전송(Retry), dead-letter 큐도 설정 가능.
		- 지속성(ack, durable queue) 설정도 가능 => 메시지 유실 방지 가능.
		- 프로듀서/컨슈머 분리 구조에 강함 => 메시지를 분석, 번역 등의 단계별로 작업하기 좋음.
		- - Kafka보다 처리량은 낮음 (수천 ~ 수만 TPS).
		- 대용량 로그 스트리밍에는 적합하지 않음.
	- `Redis` 
		- Pub/Sub 은 다른 메시지 브로커와 다르게 메시지 지속성❌ 즉, **메시지를 전송한 후 해당 메시지는 삭제**되며 **Redis 어디에도 저장되지 않음**
		- 인메모리 구조로 입력과 출력이 빨라 실시간 데이터 처리에 매우 적합하지만, 메시지가 저장되지 않음
		- 메시지 전송 신뢰성을 보장하지 않기 때문에 단점을 보완할 별도의 추가 구현이 필요
	- `Kafka` 
		- **대량의 데이터를 저장**하면서 **높은 처리량**의 필요에 적합한 메시지 브로커
		- 메세지 이벤트 생성되면 전송 성공 후에도 이벤트 스트림에 로그를 계속 유지 => 에러 등 문제가 생길 시 이벤트 다시 재생 가능
		- - 대용량 로그 수집 및 실시간 분석에 최적화됨 (초당 수십만~수백만 메시지 처리 가능).
		- 메시지를 **디스크에 오래 보존**하고, **구독자가 각자 offset(partition의 메세지가 저장되는 위치)을 관리**함=>  재처리에 매우 유리
		- 스트리밍 처리도 Kafka Streams, Flink 등과 연동 가능.


```java
@Controller
public class ChatController {

    @MessageMapping("/chat.send") // 클라이언트가 /app/chat.send 로 보낸 메시지를 처리
    @SendTo("/topic/messages")    // 메시지를 /topic/messages 를 구독한 클라이언트에게 브로드캐스트
    public ChatMessage send(ChatMessage msg) {
        return msg; 
        // ChatMessage 객체가 브로커에 의해 "/topic/messages"를 구독 중인 클라이언트 모두에게 자동으로 전송
}
```
- 만약 동적으로 구독 경로를 제어하고 싶다면 `SimpMessagingTemplate`을 사용
```java
@Autowired
private SimpMessagingTemplate messagingTemplate;

@MessageMapping("/chat.send")
public void sendMessage(ChatMessage msg) {
    messagingTemplate.convertAndSend("/topic/messages", msg);
}
```

## Client
```javascript
stompClient.subscribe("/topic/messages", function(message) {
    const chat = JSON.parse(message.body);
    console.log("받은 메시지:", chat.content);
});

```

#### 비유
1. **사용자 A**가 `/app/chat.send` 우체통에 편지를 넣음
2. **서버 우체국**이 편지를 받아서 확인 (`@MessageMapping`)
3. **서버 우체국**은 편지를 보고, **/topic/messages** 구독자들한테 일괄 발송 (`@SendTo`)
4. **사용자 B, C, D** 등 `/topic/messages`를 구독 중인 모두가 편지를 받음