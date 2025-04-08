: 모든 엔티티에서 공통으로 사용하는 생성시간, 수정시간을 관리하는 클래스를 생성하여 생성시간 및 수정시간을 자동으로 관리함 => 엔티티 클래스에서 extends 해서 사용

```java
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
```

### @MappedSuperclass

: JPA의 엔티티 클래스가 상속받을 수 있는 매핑 정보를 포함하는 클래스를 지정하는 어노테이션

- **실제 테이블과 매핑X**
- 자식 클래스(Entity)에 매핑 정보만 제공
- **등록일 수정일 같은 여러 엔티티에서 공통으로 사용하는 필드 모을 때 사용**

### @EntityListeners

: **엔티티의 변화를 감지하는 리스너를 등록하는 어노테이션**

- 엔티티의 생명주기 이벤트(저장, 수정 등)에 대해 이벤트를 발생시킴
- 이벤트에 대해 실행할 메서드를 지정하여 호출
  **@EntityListeners(AuditingEntityListener.class)**
- `AuditingEntityListener.class`에 이벤트에 대해 실행할 메서드가 정의되어 있음 -**`@EnableJpaAuditing`**: JPA Auditing 기능을 활성화하는 어노테이션 => ⚠️ 엔티티 생성, 수정 이벤트를 감지하기 위해서 **메인 애플리케이션 클래스에 적용**해야함

```java
@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
