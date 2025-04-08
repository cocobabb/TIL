
### LAZY 
  - 지연 로딩
  - 주 엔티티 loading될 때 **주 엔티티 쿼리문 1개만 실행**됨
	=> **연관된 엔티티는 Proxy 객체에 저장 후**(실제 데이터는 로딩되지 않은 상태) 
	    **연관된 엔티티의 세부 데이터에 접근할 때 조인 쿼리문들이 개별적으로 실행**됨
	=> 불필요한 DB 접근 최소화 
	=> 성능 향상

### EAGER
- 즉시 로딩
- 주 엔티티가 loading 될 때 연관된 엔티티의 데이터가 쓰이지 않더라도
	연관된 모든 엔티티의 조인 쿼리문들이 개별적으로 동시에 실행됨 
	**(주엔티티 + 연관된 엔티티 수) 만큼 쿼리문 실행됨**
	=> 불필요한 DB 접근 많아짐
	=> 성능 저하


### Fetch Join
- Lazy(지연로딩) 사용 시 특정 연관된 엔티티가 같이 실행되어야 할 때 사용
	=> 주 엔티티가 loading 될 때 **주 엔티티 쿼리문과 Fetch를 적용한 연관된 엔티티 쿼리문이 함께 1개로 실행됨**
	=> DB 접근 최적화
	=> 성능 향상
	ex)
```Java
@Query("SELECT m FROM Member m JOIN FETCH m.team")
List<Member> findAllWithTeam();
```

#### `@EntityGraph`
: JPA가 제공하는 fetch join을 간단히 사용할 수 있는 기능
- attributePaths에 바로 fetch join할 속성 지정
Repository
```java
@EntityGraph(attributePaths = {"comments"})
@Query("SELECT p FROM Post p")
List<Post> findAllWithCommentEntityGraph();
```
Controller
```java
@GetMapping("/nplus1/entity-graph")
public void LoadingExample5(){
    List<Post> posts  =postRepository.findAllWithCommentEntityGraph();
    posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
}
```

