: Spring Framework에서 HTTP 응답을 상세하게 제어할 수 있게 해주는 클래스

- HTTP Status Code : 요청 처리 상태를 나타내는 코드
	Successful responses(200~299)
	- 200 (OK) : 요청 성공
	- 201 (Created) : 리소스 생성 성공
	- 204 (No Content) : 요청은 성공했지만 응답 데이터 없음

	Redirection messages (300 – 399)
	
	Client error responses (400 – 499)
    - 400 (Bad Request) : 잘못된 요청
    - 401 (Unauthorized) : 인증 필요
    - 403 (Forbidden) : 권한이 없는 요청
    - 404 (Not Found) : 리소스를 찾을 수 없음
    - 405(Method Not Allowed) : 허용되지 않은 메서드
    
    Server error responses (500 – 599)
    - 개발자 잘못


- **HTTP Headers** : **응답에 대한** 추가 **정보를 담는** 헤더. 본문 내용이나 동작 방식 등을 제어하는데 사용
	- `Content-Type`: 요청이나 응답의 데이터 형식 (JSON, XML 등)
	- `Authorization`: 인증 토큰이나 자격 증명
	- `Cache-Control`: 캐시 관리
	- `Accept`: 서버가 반환할 콘텐츠 유형
	- `Response Body` : 실제 데이터를 담는 본문

### ResponseEntity 사용법
- `ResponseEntity<T>`의 형태
```Java
ResponseEntity.ok(data);
```
- ok() : 200 상태 코드
- created(URI location) : 201 상태 코드, Location 헤더 포함
- noContent() : 204 상태 코드
- badRequest() : 400 상태 코드
- notFound() : 404 상태 코드
- body가 없는 경우 `build()`를 사용
    - `ResponseEntity.*noContent*().build();`

- 상태 코드와 헤더를 담은 응답
```Java
ResponseEntity
    .status(HttpStatus.OK)
    .header("Custom-Header", "value")
    .body(data);
```

### API 응답 구조화
: 서버에서 클라이언트로 전달하는 데이터의 형식을 일관되게 설계하는 것

- 현재는 응답의 body에 데이터만 전달이 되는데, client를 위하여 추가적인 data를 전달 가능
장점
- 프론트엔드 개발 효율성
	- 모든 API가 동일한 구조로 응답하므로 공통 처리가 가능
	- 성공/실패 여부를 명확하게 판단 가능
- 에러 처리 용이성
	- 상세한 에러 메시지와 코드를 전달
	- 백엔드에서 문제상황 파악 후 전달하므로 프론트엔드에서 에러 상황별 대응이 쉬움
- 확장성과 유지보수성
	- API 문서화가 용이
	- 버전 관리 용이

일반적인 응답 구조
- message: 응답에 대한 설명 메시지
- code: 비즈니스 처리 결과 코드
- data: 실제 응답 데이터