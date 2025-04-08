
### Soc(Separation of Concerns)
: 하나의 프로그램을 각각의 **독립된 관심사로 분리하는 설계 원칙**
- 프로그램의 각 부분이 단일한 목적을 가지도록 구성
장점
- 코드의 유지보수성 향상: 특정 부분을 수정할 때 다른 부분에 영향을 주지 않음
- 재사용성 향상: 분리된 각 모듈을 다른 프로젝트에서도 사용 가능
- 테스트 용이성: 각 부분을 독립적으로 테스트 가능
- 협업 용이: 개발자들이 **각자 맡은 부분을 독립적으로 개발 가능**

****
### 3계층 아키텍처(3-Tier Architecture)
: 소프트웨어 시스템을 Presentation Layer, Business Layer, Data Layer로 나누는 설계 패턴
- 각 계층은 독립적으로 개발 및 유지보수가 가능하며 **서로 명확히 분리되어 있어 변경 시 영향을 최소화 가능**

#### Presentation Layer (표현 계층)
: 사용자와의 상호작용을 담당

- 데이터를 입력받아 Business Layer에 전달
- 스프링에서는 Controller가 해당


#### Business Layer (비즈니스 계층)
: 비즈니스 로직과 애플리케이션의 핵심 기능을 처리

- 데이터의 유효성을 검증하고 Presentation Layer와 Data Layer를 중계
- 스프링에서는 Service가 해당


#### Data Access Layer (데이터 접근 계층)
: 데이터베이스와의 상호작용을 담당

- 데이터를 저장, 조회, 업데이트, 삭제하는 기능을 제공
- 스프링에서는 Repository가 해당

****
### MVC 패턴

Model
: 애플리케이션의 데이터와 비즈니스 로직 담당(repository, service)
- 3계층 아키텍처에서 Business Layer와 Data Access Layer과 같은 역할

View
: 사용자에게 보여지는 화면 =>  HTML, JSP, Thymeleaf
- REST API를 사용할 경우 Json 형태의 데이터가 View라 볼 수 있음

Controller
: 사용자의 요청을 받아서 Model 과  View를 연결하는 역할
- 3계층 아키텍처에서 Presentation Layer와 같은 역할
