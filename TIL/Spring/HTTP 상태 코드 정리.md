

### 2XX: Successful responses
- 200 OK: 요청 성공
- 201 Created: 리소스 생성 성공
- 204 No Content: 요청 성공했지만 응답 데이터 없음

### 3XX: Redirection messages



### 4XX: Client error responses
- 400 Bad Request: 잘못된 요청
- 401 Unauthorized
- 403 Forbidden : 콘텐츠에 접근할 권리 없음
	401과 다른 점: 클라이언트가 인증(Authentication)된 상태고 권한(Authorization)은 없는 것
- 404 Not Found: 리소스를 찾을 수 없음

### 5XX: Server error responses
- 500 Internal server error: 웹 사이트 서버에 문제 있음
- 502 Bad Gateway: 서버가 게이트웨이로부터 잘못된 응답 수신함
	=> 인터넷상의 서버가 다른 서버로부터 유효하지 않은 응답 받음
- 504 Gateway Timeout: 서버가 게이트웨이 역할을 하고 잇으며 적시에 응답 받을 수 없을 때