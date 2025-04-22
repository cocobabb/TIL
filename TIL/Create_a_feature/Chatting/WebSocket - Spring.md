
참고: https://docs.spring.io/spring-framework/reference/web/websocket.html

: 단일 TCP 연결을 통해 클라이언트와 서버 간에 양방향 통신 채널을 설정하는 표준화된 방법을 제공
1. WebSocket 메시징
2. SockJS를 통한 WebSocket 에뮬레이션 =>  WebSocket 대신 SockJS 클라이언트(웹소켓과 유사한 객체를 제공하는 브라우저, JS 라이브러리)를 기본 전송 수단으로 사용하는 방법
3. **WebSocket을 통한 하위 프로토콜인 STOMP를 통한 게시-구독 메시징에 대한 지원**

-  HTTP와는 다른 TCP 프로토콜이지만, 80번과 443번 포트를 사용하고 기존 방화벽 규칙을 재사용할 수 있도록 HTTP를 기반으로 설계
- WebSocket 상호작용은 **HTTP `Upgrade`헤더를 사용하여 WebSocket 프로토콜로 전환하는 HTTP 요청으로 시작**
```yaml
GET /spring-websocket-portfolio/portfolio HTTP/1.1
Host: localhost:8080
Upgrade: websocket # header
Connection: Upgrade # 연결
Sec-WebSocket-Key: Uc9l9TMkWGbHFD2qnFHltg==
Sec-WebSocket-Protocol: v10.stomp, v11.stomp
Sec-WebSocket-Version: 13
Origin: http://localhost:8080
```
- 일반적인 200 상태 코드 대신 WebSocket을 지원하는 서버는 다음과 유사한 출력을 반환
```yaml
HTTP/1.1 101 Switching Protocols # switching
Upgrade: websocket
Connection: Upgrade
Sec-WebSocket-Accept: 1qVdfYHU9hPOl4JYYNXF623Gzn0=
Sec-WebSocket-Protocol: v10.stomp
```
- 성공적인 핸드셰이크 후(switching 후),  HTTP 업그레이드 요청을 기반으로 하는 **TCP 소켓은 클라이언트와 서버 모두가 메시지를 계속 보내고 받을 수 있도록 열림**


## WebSocket 연결과 HTTP REST 연결의 차이점
#### **HTTP REST 연결**
-  **여러 개의 URL**로 모델링(ex: GET, POST, PUT, PATCH, DELETE)
- 애플리케이션과 클라이언트 **요청-응답 방식** 으로 URL에 접근
- Server가 HTTP URL, 메서드, Header를 기반으로 적절한 핸들러로 요청 라우팅-
#### **WebSocket 연결**
- 초기 연결 **URL  하나만 존재**
- 모든 애플리케이션 메시지 동일한 **TCP 연결**을 통해 전달 => 비동기 이벤트 기반 메시징 아키텍처
-  HTTP와 달리 메시지 내용에 대한 의미(ex: GET, POST 등)를 규정❌ =>**클라이언트와 서버가** 메시지 **의미에 동의하지 않으면 메시지를 라우팅하거나 처리할 방법❌**