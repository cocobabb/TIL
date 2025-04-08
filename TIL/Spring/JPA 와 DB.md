### JPA와 DB연결시작
spring initializr으로 프로젝트 생성 시 Dependencies에 Spring Data JPA와 사용할 DB driver을 추가하거나

생성 시 추가 못한 경우
`build.gradle`파일에 아래와 같이 추가
```Java
dependencies {
  ...
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	runtimeOnly 'com.mysql:mysql-connector-j'
}
```

### DB와의 연결
`src/main/resources/application.properties`에 아래와 같이 작성
```Java
# database와 연결
// spring.datasource.url=jdbc:mysql:연결할 서버 IP:DB와 연결될 Port 번호/생성한DB이름
spring.datasource.url=jdbc:mysql:localhost:3306/demodb
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# 추가 설정
# JPA가 생성하는 SQL을 콘솔에 출력
spring.jpa.show-sql=true
          
# 데이터베이스 스키마 자동 생성
spring.jpa.hibernate.ddl-auto=create   
# create => 서버 실행 시 마다 DB 초기화
# update => 서버 실행 시 마다 DB 유지
```
### Entity mapping
: Java의 class와 DB의 테이블을 연결

#### @Entity 
: JPA가 관리하는 객체임을 명시하는 어노테이션
- **DB의 테이블과 매핑됨**
- @Table(name={table_name})을 활용하여 이름이 다른 테이블과 연결 가능
- **엔티티에는 기본 생성자가 필수**
- **final 필드, final 클래스(상속 불가능한 클래스)는 사용이 불가**
- getter는 대부분의 필드에 필요하지만, setter의 경우 사용되는 경우에만 작성
    - setter의 경우 의미있는 메서드명으로 활용
        ex) OrderStatus ⇒ cancelOrder / Address ⇒ changeAddress
#### @Id
: **기본 키를 매핑**하는 어노테이션

#### @GeneratedValue
: **기본 키 자동 생성**해주는 어노테이션으로 @Id 어노테이션과 같이 사용됨
 **strategy 속성**
- `GenerationType.IDENTITY`:  DB의 IDENTITY 컬럼을 사용하여 자동 증가 
	=> **MySQL, PostgreSQL**과 같은 DB에서 주로 사용(DB의 `AUTO_INCREMENT` 기능을 활용)
```Java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

- `GenerationType.SEQUENCE` : DB의 시퀀스 객체를 사용
	=> **Oracle, PostgreSQL** 과 같은 DB에서 주로 사용하며 `@SequenceGenerator`를 함께 사용하여 시퀀스 이름과 설정을 지정 가능
```Java
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
@SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
private Long id;
```
- `GenerationType.TABLE` : 키 값을 저장하는 별도 테이블을 생성하여 관리
	=>  성능이 떨어질 수 있어 잘 사용되지 않음
```Java
@Id
@GeneratedValue(strategy = GenerationType.TABLE, generator = "user_table")
@TableGenerator(name = "user_table", table = "id_generator", pkColumnName = "gen_name",
    valueColumnName = "gen_value", pkColumnValue = "user_id", allocationSize = 1)
private Long id;
```
#### @Column 어노테이션
: JPA에서 테이블의 컬럼을 매핑하고 컬럼의 속성을 정의하는데 사용

name: 컬럼명 지정
- 기본값: 필드명과 동일
	ex) **@Column(name = "user_name")**

nullable: NULL 허용 여부
- 기본값: true
	ex) **@Column(nullable = false)**

length: 문자열 길이 제한
- 기본값: 255
	ex) **@Column(length = 100)**

unique: 유니크 제약조건 설정
- 기본값: false
	ex) **@Column(unique = true)**

updatable: 컬럼 수정 가능 여부
- 기본값: true
	ex) **@Column(updatable = false)**

columnDefinition: 컬럼 정의를 직접 지정
	ex) **@Column(columnDefinition = "TEXT")**


### @Entity와 같이 쓰는 Lombok 어노테이션
- @Getter
- @Setter
- @NoArgsConstructor(access = AccessLevel.PROTECTED)
    : 파라미터가 없는 기본 생성자를 생성
    - `access = AccessLevel.PROTECTED`를 통해 접근제어자를 protected로 설정 가능
```Java
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
}
```
### ### 기타 어노테이션
- @Enumerated(EnumType.STRING)
    : 자바 enum 타입을 엔티티 클래스에서 사용할 때 사용
    - EnumType.STRING : enum의 이름을 DB에 저장
```java
// enum 정의
public enum Status {
    ACTIVE,
    INACTIVE,
    PENDING,
    BANNED
}
```
```java
@Entity
public class SomeEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;  // DB에 'ACTIVE', 'INACTIVE' 등으로 저장됨
}
```

### JpaRepository
: Spring Data JPA에서 제공하는 **데이터 접근 인터페이스**
- Repository 인터페이스만 작성하면 **실제 구현체는 Spring이 자동으로 생성**
- 기본적인 CRUD 메서드를 제공
	저장 및 수정
    - `.save(instance)`: 단일 엔티티에 대해 있으면 수정, 없으면 저장
	
	조회(find) => SELECT 쿼리 자동 생성
	- `.findAll()`: **모든 엔티티** 조회
		- `List<T>` 반환
	- `.findById(id)`: **단일 엔티티** 조회
		- `Optional<T>` 반환
	- And, Or
	    - `findByUsernameAndAge(String username, int age)`
	- Between
	    - `findByAgeBetween(int startAge, int endAge)`
	- LessThan, GreaterThan
	    - `findByAgeLessThan(int age)`
	- Like
	    - `findByUsernameLike(String username)`
	    - argument에 와일드카드 사용 가능
	- Containing
	    - `findByEmailContaining(String emailDomain);`
	- OderBy
	    - `findByAgeOrderByUsernameAsc(int age);`
	- boolean의 경우
	    - `findByFieldFalse()`
	    - `findByFieldTrue()`
	    - 로 field의 값에 따라 조회도 가능
		
	삭제
	- `delete(instance)`:  단일 엔티티 삭제
	- `deleteById(id)`:  ID로 엔티티 삭제
		- 엔티티가 없으면 `EmptyResultDataAccessException` 발생
	
	유틸리티 메서드
	- `count()`:  엔티티 총 개수 반환
	- `existsById(id)`: ID로 엔티티 존재 여부 확인
	
- `JpaRepository<엔티티타입, ID타입>`을 상속하여 사용
```Java
public interface PostRepository extends JpaRepository<Post, Long> {
}
```

### JPQL
: **테이블명이 아닌 엔티티명 사용**
- JPA 엔티티 객체를 조회하는 객체지향 쿼리 언어
- SQL과 비슷한 문법이지만, **테이블이 아닌 엔티티 객체를 대상으로 쿼리**
	- **특정 데이터베이스에 종속X => 다른 데이터베이스(Oracle 등 )로 변경 가능
```Java
// SQL
SELECT p.title, p.author FROM posts p WHERE p.category = 'Tech';

// JQPL
SELECT p.title, p.author FROM Post p WHERE p.category = 'Tech';
```

```java
// 기본 SELECT
"SELECT m FROM Member m"

// WHERE
"SELECT m FROM Member m WHERE m.age > 18"

"SELECT m FROM Member m WHERE m.age > 18 AND m.username LIKE 'kim%'"

// ORDER BY
"SELECT m FROM Member m ORDER BY m.age ASC"

// GROUP BY
"SELECT m.team.name, COUNT(m) FROM Member m GROUP BY m.team.name"
```
### Dirty Checking

- 영속성 컨텍스트에 관리되는 **엔티티가 변경되었는지 자동으로 감지**하여, **트랜잭션이 커밋될 때 변경된 내용을 데이터베이스에 반영**하는 메커니즘
- JPA가 **영속 상태로 관리하는 엔티티에서만 동작**
- 주로 데이터를 수정할 때 사용된다.
- JPQL 키워드는 대소문자 구분하지 않음(**엔티티명은 대소문자 구분**)
- 별칭이 필수
- 묵시적 조인(WHERE절을 이용한 조인)보다는 명시적 조인(JOIN절을 통한 조인) 권장


### Parameter Binding
:  JPQL 쿼리의 입력 값이 자동으로 **Escape 처리(공격자가 입력하는 ' (싱글쿼트)나 " (더블쿼트) 같은 특수 문자를 단순한 문자열로 취급하도록 변환)** 되서 ==SQL Injection 공격을 막을 수 있음==
- **`:` 뒤에 변수를 넣을 수 있음**
```java
public interface PostRepository extends JpaRepository<Post, Long> {
	@Query("SELECT p FROM Post p WHERE p.author = :author")
	List<Post> findByAuthor(@Param("author") String author);
}
```
-  **수정, 삭제의 경우는 `@Modifying`어노테이션이 필수**

```java
public interface PostRepository extends JpaRepository<Post, Long> {
	@Modifying
	@Query("UPDATE Post p SET p.title = :title WHERE p.id = :id")
	int updateTitle(@Param("id") Long id, @Param("title") String title);
}
```
### SQL Injection 예시
SQL Injection 공격 받기 쉬운 구조
```java
String username = "kim";

String jpql = "SELECT m FROM Member m WHERE m.username = '" + username + "'";
```

- **' OR '1'='1` -- **
```sql
SELECT * FROM users WHERE username = '' OR '1'='1'
```
입력 없이 빈칸이거나 1=1은 항상 참이여서 쿼리문이 실행됨 => 로그인 시스템의 겨우 비밀번호 없이 모든 계정에 접근할 수 있는 위험성  
**(`--`는 SQL 주석이므로 뒤의 `'`는 무시됨)**


- **'; DROP TABLE users; --**
```sql
SELECT * FROM users WHERE username = ''; DROP TABLE users; --'
```
 **`DROP TABLE users;`가 실행되면서 `users` 테이블이 삭제됨**
 **(`--`는 SQL 주석이므로 뒤의 `'`는 무시됨)**

