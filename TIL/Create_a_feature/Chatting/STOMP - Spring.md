참고: https://docs.spring.io/spring-framework/reference/web/websocket/stomp.html
https://docs.spring.io/spring-framework/reference/web/websocket/stomp/enable.html

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
- 외부 브로커를 사용하는 경우, 브로커의 STOMP 페이지를 확인하여 지원하는 STOMP 대상과 접두사의 종류를 확인할 것


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