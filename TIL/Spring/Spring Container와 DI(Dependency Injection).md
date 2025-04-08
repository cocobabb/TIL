
### Spring Container
: Spring Bean의 생명주기를 관리하는 핵심 요소
- 객체의 생성, 관리, 제거를 담당
	⇒ 스프링 빈을 모아두고 관리하는 장소

#### Spring Bean
: **스프링 컨테이너가 관리하는 자바 객체(인스턴스) => 클래스 파일**
- Bean 등록 방법
    - 컴포넌트 스캔과 @Component 어노테이션을 통한 자동 등록
    - 자바 설정 클래스에서 @Bean을 통한 수동 등록

### 스테레오타입 어노테이션
- `@Component`: 일반적인 스프링 빈으로 등록하는 기본 어노테이션
- **`@Component`를 포함하는 세부 어노테이션들**
    - **`@Controller`: 웹 MVC 컨트롤러로 사용되는 클래스 지정**
    - **`@RestController`: REST API 컨트롤러로 사용되는 클래스 지정**
    - **`@Service`: 비즈니스 로직을 처리하는 서비스 계층의 클래스 지정**
    - **`@Repository`: 데이터 접근 계층의 클래스 지정**
    - **`@Configuration`: 설정을 위한 클래스 지정**
@Component를 포함하고 있음 => @Component는 스프링 Bean을 등록하는 기본 어노테이션임
=> @Component를 포함하는 어노테이션은 Spring Bean임

****

### 제어의 역전(IoC, Inversion of Control,)
: 기존의 개발은 원래 개발자가 **객체를** 직접 **생성하고 관리**하는  등 제어의 주체가 되었지만 **스프링에서는 컨테이너가 대신 관리하고 개발자는 비즈니스 로직만 신경씀**

### 의존성 주입(DI, Denpendency Injection)
: 객체가 필요로 하는 의존성을 외부에서 주입하는 방식, **생성자를 생성할 때 파라미터로 필요로 하는 객체 받아오는 것** 
```Java
// DI 없이 직접 객체 생성(컴포지션) - 강한 결합
public class UserService {
    // UserRepository 구현체를 직접 생성 - 변경이 어려움
    private UserRepository repository = new MySQLUserRepository();
}

// DI 사용 - 느슨한 결합
public class UserService {
    private final UserRepository repository;  // 인터페이스에 의존
    
    // 어떤 구현체든 주입 가능 (MySQL, MongoDB, Redis 등)
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
}
```
#### DI 3가지 방식
- 생성자 주입(Constructor Injection)
```Java
@Service
public class UserService {
    private final UserRepository userRepository;

// 생성자가 하나면 @Autowired 생략 가능
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

```
- 수정자 주입(Setter Injection) => set 메서드를 이용한 방법
```Java
@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```
- 필드 주입(Field Injection)
```Java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
```
****
### @Autowired
: 스프링 컨테이너가 자동으로 의존성 주입할 때 사용
- 타입을 기준으로 의존성을 주입

#### @Autowired 사용 가능 위치
- 생성자 (생성자가 하나면 @Autowired 생략 가능)
- 수정자(setter)
- 필드

#### @Autowired 동작 원리
```Java
@Autowired
private UserRepository userRepository;
```
- 주입 시점
    1. 스프링 컨테이너가 Spring Bean을 생성
    2. @Autowired가 붙은 위치에 의존성을 주입
- 주입 대상 탐색
    3. 타입이 같은 빈을 찾음
    4. 여러 개의 빈이 있다면:
        - @Primary가 있는 빈을 주입
        - @Qualifier로 지정된 빈을 주입
        - 이름이 같은 빈을 주입
    5. 위 조건으로도 구분이 안 되면 오류 발생