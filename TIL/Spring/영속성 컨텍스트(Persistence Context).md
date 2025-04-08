: 엔티티를 영구 저장하는 환경
- `EntityManager`를 통해 엔티티를 관리
- 애플리케이션과 데이터베이스 사이에서 중간 계층의 역할을 함
- **트랜잭션 단위로 생성되고 관리**
- 1차 캐시
    - **영속 상태의 엔티티는 모두 1차 캐시에 저장**
    - 조회 시 **먼저 1차 캐시에서 찾고, 없으면 DB에서** 조회
- 동일성 보장
    - 같은 엔티티를 조회하면 항상 같은 인스턴스를 반환
```Java
Post post1 = em.find(Post.class, 1L);
Post post2 = em.find(Post.class, 1L);
System.out.println(post1 == post2);// true
```
- 트랜잭션을 지원하는 쓰기 지연
    - 트랜잭션 커밋 전까지 SQL을 보내지 않고 모아둠
    - 커밋하는 순간 모아둔 SQL을 DB에 보냄
- 변경 감지 (Dirty Checking): 엔티티의 변경사항을 자동으로 감지
    - **트랜잭션 커밋 시점에 변경된 엔티티를 찾아 UPDATE SQL을 생성**
- **지연 로딩: 연관된 엔티티를 실제 사용하는 시점에 로딩하는 방식**

### 엔티티의 생명주기
- 비영속 (new/transient): 영속성 컨텍스트와 전혀 관계가 없는 상태
- 영속 (managed): 영속성 컨텍스트에 저장된 상태
- 준영속 (detached): 영속성 컨텍스트에 저장되었다가 **분리된 상태**
	- **영속성 컨텍스트가 제공하는 기능을 사용할 수 없음**
- 삭제(removed): 영속성 컨텍스트와 데이터베이스에서 삭제된 상태


## EntityManager와 EntityTransaction
- EntityManager를 통해 영속성 컨텍스트를 관리
    - 모든 작업이 끝난 후에는 `close()`를 호출해야 함
- EntityTransaction을 통해 트랜잭션을 관리
    - 데이터 변경 작업이 끝난 후에는 반드시 `commit()`을 호출해야 함
    - 예외가 발생하면 반드시 `rollback()`을 호출해야 함


### JPQL
: JPA 엔티티 객체를 조회하는 객체지향 쿼리 언어
- SQL과 비슷한 문법이지만, 테이블이 아닌 **엔티티 객체를 대상으로 쿼리함**
- 특정 DB에 종속적이지 않음

```Java
// SQL
SELECT p.title, p.author FROM posts p WHERE p.category = 'Tech';

// JQPL
SELECT p.title, p.author FROM Post p WHERE p.category = 'Tech';
```

```Java
// SQL
SELECT c.text 
FROM posts p 
JOIN comments c ON p.id = c.post_id
WHERE p.title = 'Hello World';

// JPQL
SELECT c.text 
FROM Post p 
JOIN p.comments c 
WHERE p.title = 'Hello World';
```

### Dirty Checking
: **영속성 컨텍스트에 관리되는 엔티티**가 변경되었는지 자동으로 감지하여, **트랜잭션이 커밋될 때 변경된 내용을 DB에 반영하는 메커니즘**
- JPA가 **영속 상태**로 관리하는 엔티티에서만 동작
- 주로 **데이터를 수정할 때 사용**

****
### @Transactional
:  클래스나 메서드에 적용하여 트랜잭션을 관리
- `readOnly`속성을 활용하여 읽기 전용 트랜잭션으로 설정 가능
    =>조회 성능을 최적화
- `import org.springframework.transaction.annotation.Transactional;` 을 활용
- **@Transactional이 붙은 메서드가 호출**되면 스프링은 다음과 같이 동작
    1. **트랜잭션 시작**
    2. **메서드 실행**
    3. **예외가 발생하지 않으면 커밋 (em.getTransaction().commit())**
    4. **예외가 발생하면 롤백 (em.getTransaction().rollback())**
    5. **EntityManager 자동 close**

### @Transactional의 위치
: 일반적으로 `@Transactional`은 **`Service` 계층에서 관리**
- Service 계층은 비즈니스 로직을 수행하고 **하나의 비즈니스 로직은 여러 Repository 메서드를 호출 가능**
- **모든 Repository 메서드가 하나의 트랜잭션으로 처리되어야 함**
=> Service클래스에 @Transactional(readOnly = true)를 설정하고, 쓰기 메서드에만 @Transactional을 추가하는 방식으로 주로 활용

```Java
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

	@Transactional
	public Post createPost(Post post) {
	    return postRepository.save(post);
	}

	public List<Post> readPosts(){
	    return postRepository.findAll();
	}

	@Transactional
	public void deletePost(Long id){
	    postRepository.delete(id);
	}
}
```
```Java
@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final EntityManager em;
}
```