: 불변데이터 객체를 생성하기 위한 특별한 종류의 클래스
- 불변데이터 객체를 생성하기 위한 특별한 종류의 클래스
    - 생성자
    - getter 메서드
    - equals()
    - hashCode()
    - toString()
    을 자동으로 만들어줌
- Java 14부터 도입


장점
- 불변성을 보장
	- 모든 필드가 final
	- setter 생성 불가능
- 명확한 의도 전달이 가능
	- DTO나 데이터 전달용 객체임을 바로 알 수 있음
	- 코드 가독성 향상
단점
- 상속 불가능
- 추가 필드 선언 불가능
- 모든 필드가 final (장점이자 단점)
- Builder 패턴 사용이 불가능
	- @Builder 어노테이션 적용 불가
	- 필드가 많을 때 생성자 사용이 불편
- **JPA 엔티티로 사용 불가**
	- 기본 생성자 없음
	- 필드 수정 불가
	- 프록시 생성 불가

기존 DTO
```java
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class PostDto {
    private final Long id;
    private final String title;
}
```
Record
```java
public record PostDto(Long id, String title) {}
```
=> **단순한 DTO의 경우 사용하면 좋으나, 필드가 많은 경우는 기존의 방식이 유리**