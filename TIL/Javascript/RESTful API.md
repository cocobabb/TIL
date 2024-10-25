: 두 컴퓨터 시스템이 인터넷을 통해 정보를 안전하게 교환하기 위해 사용하는 인터페이스
**웹 API의 일반적인 디자인 원칙을 정의**

### Request
: 요청을 통해 어떤 데이터(resourece)에게 어떤 동작을 하고, 어떤 응답을 바라는지 알 수 있음

### HTTP method
+ **GET** : 데이터 조회
+ **POST** : 데이터의 생성
+ **PUT** : 데이터의 수정
+ **DELETE** : 데이터의 삭제

### 추가적인 데이터
- **HTTP header**
    - 요청 헤더는 클라이언트와 서버 간에 교환되는 메타데이터가 포함
    - 예를 들어, 요청 헤더는 요청 및 응답의 형식을 나타내고 요청 상태 등에 대한 정보를 제공
- **데이터**
    - 데이터를 생성, 수정하는 경우
- **파라미터**
    - 리소스에 대한 추가 정보를 요청하는 쿼리 파라미터.
    - 클라이언트를 빠르게 인증하는 쿠키 파라미터.

### Response
: 요청에 대한 응답

### 데이터의 표현

- 요청에 대한 응답으로 JSON형식을 주로 사용
- JSON(JavaScript Object Notation)
    - 속성-값 쌍(attribute–value pairs), 배열 자료형(array data types) 또는 기타 모든 시리얼화 가능한 값(serializable value) 등을 전달하기 위해 인간이 읽을 수 있는 텍스트를 사용하는 개방형 표준 포맷이다.
    - serialization(직렬화)
        - 데이터 구조나 오브젝트 상태를 동일하거나 다른 컴퓨터 환경에 저장하고 나중에 재구성할 수 있는 포맷으로 변환하는 과정이다.
        - 즉, python에서 사용하는 list, dictionary등의 객체를 다른 환경에서도 사용할 수 있도록 변환하는 것을 말한다.
- 과거에는 XML형식을 주로 사용했었다.

### HTTP status code
: 요청이 성공했는지, 추가 조치가 필요한지, 오류가 발생했는지 등을 나타내는 표준화된 코드

- Informational responses (100 – 199)
- Successful responses (200 – 299) :정상 동작
- Redirection messages (300 – 399)
- Client error responses (400 – 499) : 사용자 잘못
- Server error responses (500 – 599) : 개발자 잘못

## API 엔드포인트(API endpoint)
: **API가 서비스를 제공하기 위해 네트워크 상에서 호출할 수 있는 특정 URL 주소**
API가 리소스에 접근하고 데이터를 조회, 생성, 수정, 삭제하는 등의 작업을 수행할 수 있게 하는 진입점
### Interface
: 서로 다른 **두 개의 시스템, 장치 사이에서 정보나 신호를 주고 받는** 데 도움을 주는 시스템

### API(Application Programming Interface)
: 소프트웨어 애플리케이션이 서로 상호작용 할 수 있도록 하는 인터페이스

### URI(Uniform Resource Identifier)
: 인터넷에 있는 자원에 대한 식별자
+ URL(Uniform Resource Locator)
	: 인터넷에 있는 자원을 식별하는 주소
+ URN(Uniform Resource Name)
	: 인터넷에 있는 자원을 식별하는 이름


![[Pasted image 20241025185855.png]]

+ **Scheme**
	: **브라우저가 resource를 요청하는 데 사용**해야 하는 프로토콜
		http, https, ftp(파일전송)
+ **Domain name**
	:  **웹 서버 또는 IP 주소**
+ **Port**
	:  **웹 서버의 resource에 접근**하는 데 사용되는 기술적인 게이트
+ **Path to the file**
	: 웹 서버에 있는 **resource의 경로**
+ **Parameters 또는 Query parameter**
	:  **웹 서버에 제공되는 추가적인 정보** & 기호로 구분된 키/값 쌍으로 주어짐
+ **Anchor**
	: **resource 내부에 해당 id값의 tag에서부터 화면에 보여줌**
