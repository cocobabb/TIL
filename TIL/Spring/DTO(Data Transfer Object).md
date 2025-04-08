: 계층간 데이터 전달을 위한 객체

- Entity와 DTO를 분리하는 이유
  - 도메인 모델의 변경으로부터 API 스펙을 보호
  - 불필요한 데이터 전송 방지
  - 양방향 연관관계로 인한 순환참조 문제 방지
  - API 스펙에 맞는 유연한 데이터 구조 제공

### Entity

: 실제 DB 테이블과 매핑되는 클래스

- 기본 키, 컬럼, 연관 관계(예: `@OneToMany`, `@ManyToOne`) 등을 정의
- 비즈니스 로직 포함할 수 있음
- 데이터의 영속성을 담당

### DTO

: 오직 데이터 전달만을 위한 클래스

- 클라이언트에게 필요한 필드만 포함
- 비즈니스 로직을 포함 Ⅹ
- 각 API에 맞는 데이터 구조 제공

### Request DTO

: 클라이언트에서 서버로 데이터를 전달할 때 사용하는 객체

- 주로 **@RequestBody와 함께 사용**
- 데이터 유효성 검증을 위한 어노테이션이 포함될 수 있음
- @RequestBody 와 사용되기 위해 **`@NoArgsConstructor`를 필요(매개변수가 없는 생성자 => 기본 생성자 필요)**

### Response DTO

: 서버에서 클라이언트로 데이터를 반환할 때 사용하는 객체

- Entity의 **민감한 정보를 제외하고 필요한 정보만 전달**
- **여러 Entity의 데이터를 조합하여 반환 가능**
- **필드에 `final`**을 함께 사용

### Lombok의 Builder 패턴

: 복잡한 객체의 생성 과정과 표현 방법을 분리하여 다양한 구성의 인스턴스를 만드는 생성 패턴

- Entity 클래스에 id 필드 제외한 `build`가 필요하니 메서드 레벨의 @Build 설정
- DTO는 전체 필드에 대해 `build`가 필요하니 클래스 레벨의 @Build 설정

### Entity

```Java
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String email;

    @Builder
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
```

### RequestDTO

```Java
@Getter
@Builder
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 매개변수 있는 생성자 자동 생성
public class UserCreateRequestDto {
    private String name;
    private String email;
}
```

---

## 정적 팩토리 메서드 패턴(Static Factory Method Pattern)

: 객체 생성을 캡슐화하는 패턴
=> **생성자 대신 static 메서드를 통해 객체를 생성**

##### 명확한 의도 표현

- `from()`이나 `of()` 같은 메서드 이름을 통해 객체 생성 의도를 명확히 표현 가능

##### 캡슐화된 객체 생성

- DTO를 **생성하는 과정에서 추가적인 검증이나 데이터 변환 로직이 필요한 경우 생성자 대신 팩토리 메서드에 로직을 넣을 수 있음**
- **호출할 때**마다 새로운 **객체를 생성할 필요X** (**캐싱, 객체 풀링 등 가능)**

##### 객체 생성의 유연성

- 하위 자료형 객체를 반환 가능
  - ex) 결제 객체에 대한 생성을 하였을 때 `OO결제` 인스턴스 반환

##### 무결성 보장

- 생성자를 private으로 하면 불완전하거나 잘못된 상태로 객체가 생성되는 것을 방지
- 객체 생성 시점에 추가적인 검증 로직을 수행

### ResponseDTO

=>**static factory method로 객체 생성했기 때문에 생성자 관련 어노테이션 필요X**

```Java
@Getter
@Builder
public class UserResponseDto {
   private final Long id;
   private final String name;
   private final String email;

   public static UserResponseDto from(User user) {
       return UserResponseDto.builder()
               .id(user.getId())
               .name(user.getName())
               .email(user.getEmail())
               .build();
   }
}
```

## @Build의 장점

##### 가독성 향상

- 생성자의 파라미터가 많을 때 각 값의 의미를 명확히 알 수 있음
- **선택적 파라미터 처리가 용이**

##### 불변성 보장

- **객체 생성 시점에 모든 값을 설정**
- **setter 사용을 줄여 안전한 객체 생성 가능**

##### 유연성

- 필수값과 선택값을 구분하여 처리 가능
- **다양한 객체 생성 패턴을 지원**

#### Build로 해결되는 일반 생성자로 생성 시 문제점

- 매개변수가 많을 경우 가독성이 떨어짐
- 어떤 값이 어떤 필드에 매핑되는지 알기 어려움
- **선택적 매개변수가 많을 경우 생성자 오버로딩이 증가**
