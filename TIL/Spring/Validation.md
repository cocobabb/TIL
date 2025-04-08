: 사용자가 입력한 데이터가 애플리케이션이 요구하는 규칙과 형식에 맞는지 확인 하는 과정
- 잘못된 데이터가 시스템에 유입되는 것을 방지

간단한 Validation의 경우 다음과 같이 `throw`를 통해 구현할 수 있다.
```Java
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Post createPost(@RequestBody Post newPost){
    String title = newPost.getTitle();
    String content = newPost.getContent();

    if (title == null || title.isBlank()){
        throw new RuntimeException("title을 입력하시오.");
    }

    if (content == null || content.isBlank()) {
        throw new IllegalArgumentException("content를 입력하시오.");
    }

    Post post = new Post(++id, title, content);
    posts.add(post);
    return post;
```
- **에러가 throw될 경우** method를 호출하는 **상위 어딘가에서는 반드시 try catch를 해주어야 함** => 그렇지 않으면 프로그램이 종료
- spring에서는 기본적으로 예외처리를 해줌

### Validation의 이점
- 데이터 무결성 보장
    - 잘못된 데이터가 시스템에 유입되는 것을 방지
    - 데이터베이스의 품질 유지
- 보안 강화
    - 악의적인 데이터 입력 방지
    - SQL 인젝션 등의 공격 예방
- 사용자 경험 향상
    - 잘못된 입력에 대한 명확한 안내
- 서버 부하 감소
    - 잘못된 데이터를 초기 단계에서 차단
    - 불필요한 데이터베이스 조작 방지

### Bean Validation(`@Valid`)
: Java에서 객체의 데이터를 검사하기 위한 표준화된 프레임워크
- **객체의 속성에 대한 검사 규칙을 어노테이션으로 정의**
- **도메인 모델의 유효성 검사 로직을 분리하여 관리**
- 재사용 가능한 검사 로직 구현 가능

#### 의존성 추가
- Spring Boot 2.3 이후부터는 validation이 starter-web에서 분리되었다.
- 프로젝트를 시작할 때 start.spring.io에서 Validation추가 또는 `build.gradle`에 추가
```java
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-validation'
}
```


### Controller 설정
-  요청하는 DTO에 `@Valid` 어노테이션으로 유효성 검사를 적용할 클래스 설정
```java
@PostMapping
public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO){
		...
}
```

### DTO  설정
- `@Valid`을 트리거로 DTO의 검사 어노테이션을 작동
```java
public class UserDto {
    @NotNull(message = "이름은 null일 수 없습니다.")
    @Size(min = 2, max = 50, message = "이름은 2자 이상 50자 이하여야 합니다.")
    private String name;
}
```

### 검사 어노테이션
- 공통적으로 message 속성을 가짐
- 유효하지 않은 입력 값은 MethodArgumentNotValidException을 throw
Null 관련
- `@NotNull`
    - null값인 경우
- `@NotEmpty`
    - null값이거나 빈 문자열이거나 size가 0인 Collection인 경우
    - List와 같은 Collection에서 주로 사용
- `@NotBlank`
    - null값이거나 빈 문자열이거나 공백인 경우
    - String에서 사용

문자열 관련
- `@Size(min=num, max=num)`
    - 문자열, 배열, 컬렉션의 크기가 지정된 범위를 벗어난 경우
- `@Length(min=num, max=num)`
    - 문자열의 길이가 지정된 범위를 벗어난 경우
    - `@Size`와 유사하나 문자열에만 특화
- `@Pattern(regexp="정규식")`
    - 문자열이 지정된 정규식 패턴과 일치하지 않는 경우
   
숫자 관련
- `@Min(value=num)`
    - 숫자가 지정된 값 미만인 경우
- `@Max(value=num)`
    - 숫자가 지정된 값 초과인 경우
- `@Positive`
    - 숫자가 양수가 아닌 경우
- `@Range(min=num, max=num)`
    - 숫자가 지정된 범위를 벗어난 경우

날짜 관련
- `@Past`
    - 과거 날짜가 아닌 경우
- `@PastOrPresent`
    - 현재 또는 과거 날짜가 아닌 경우
- `@Future`
    - 미래 날짜가 아닌 경우
- `@FutureOrPresent`
    - 현재 또는 미래 날짜가 아닌 경우

기타
- `@Email`
    - 문자열이 이메일 형식과 일치하지 않는 경우
- `@URL`
    - 문자열이 URL 형식과 일치하지 않는 경우

### 계층별 검증
#### Controller 계층 검증
: HTTP 요청 데이터의 기본적인 형식과 제약조건 검증
- **비즈니스 로직 수행 전에 잘못된 데이터 차단**
- 빠른 실패를 통한 **서버 리소스 절약**
- `@Valid`을 통한 DTO 클래스 검증
#### Service 계층의 검증
:  비즈니스 규칙에 따른 데이터 검증
- 여러 데이터를 조합하여 검증
- **DB 조회가 필요한 검증**
- 직접 검증 로직 구현
- **Custom Exception 활용**
ex) 게시글 개수 제한, 회원가입 시 중복 이메일 확인 등
```java
if (userRepository.existsByEmail(email)) {
    throw new DuplicateEmailException("이미 사용 중인 이메일입니다.");
}
```
### @Column 어노테이션
: JPA에서 엔티티의 필드와 테이블의 컬럼을 매핑하고 컬럼의 속성을 정의

- name: 컬럼명 지정
    - 기본값: 필드명과 동일
    - ex) @Column(name = "user_name")

- nullable: NULL 허용 여부
    - 기본값: true
    - ex) @Column(nullable = false)

- length: 문자열 길이 제한
    - 기본값: 255
    - ex) @Column(length = 100)

- unique: 유니크 제약조건 설정
    - 기본값: false
    - ex) @Column(unique = true)

- updatable: 컬럼 수정 가능 여부
    - 기본값: true
    - ex) @Column(updatable = false)

- columnDefinition: 컬럼 정의를 직접 지정
    - ex) @Column(columnDefinition = "TEXT")
### Validation과 `@Column`의 차이
- @Column
    - **DB 테이블의 스키마를 정의**
    - 애플리케이션 실행 시점에 **DB 테이블 생성에 영향**
    - **DB 레벨의 제약조건 설정**
- Validation
    - 애플리케이션 실행 중 데이터 검증
    - 요청 데이터가 **서비스 로직에 도달하기 전에 검증**
    - **비즈니스 로직 레벨의 제약조건 설정**