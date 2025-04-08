
DB 스키마에서는 댓글 테이블에서만 게시글 아이디를 FK로 가져 연관관계를 맺으면 JOIN을 통해 서로의 테이블에서 데이터를 가져올 수 있지만

JPA의 영속성 컨텍스트는 데이터베이스에 데이터를 반영하기 전까지 객체 상태로 존재하는 특성 때문에
JPA의 Entity관계에서는 댓글 Entity에서만 게시글 필드에 @ManyToOne과 @JoinColumn(name ="post_id") 으로 게시글의 아이디를 가지고 있으면
게시글 Entity에서 연관된 댓글의 데이터를 가져올 수 없다

=> 게시글 Entity의 댓글 필드에 @OneToMany(mappedBy = "post") 관계를 맺어 댓글들을 가져와야 함
(게시글 Entity에서 댓글 필드는 댓글 Entity의 게시글 필드와 매핑 되어있음
mappedBy = `[연관관계에 있는 테이블의 필드명]`)

이 때 연관관계 주인은 댓글! => 댓글의 유무에 따라 둘이 연관되고 안되고 하니까
**연관관계 주인**인 댓글에서는 **연관관계 생성 및 삭제가 가능**하지만 게시글에서는 읽기만 가능) 


### 단방향 연관관계
: 한쪽의 엔티티만 다른 엔티티를 참조
```Java
// 단방향 연관관계
@Entity
public class Comment {
    @Id @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
----------------------------------------------------------------
@Entity
public class Post {
    @Id @GeneratedValue
    private Long id;
    
}
```
### 양방향 연관관계
: 양쪽 엔티티가 서로를 참조

```Java
// 양방향 연관관계
@Entity
public class Comment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; // 게시글 참조
}
-----------------------------------------------------------------
@Entity
public class Post {
    @Id @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();// 댓글 목록 참조
}
```

### 연관관계의 종류
**★일대다(1:N)**
: 일대다 단방향은 권장하지 않으며, 다대일의 상대방으로 사용
 - **@OneToMany을 활용해 관계를 명시**
	- **mappedBy: 양방향 관계에서 연관관계의 주인**을 지정
	    - **반대쪽 엔티티의 필드명을 값으로 설정**
	- cascade: 영속성 전이 설정
		JPA에서 엔티티의 상태 변화를 연관된 엔티티에도 함께 적용하는 것 => 연관된 엔티티가 삭제되면 연결된 엔티티 데이터 삭제됨

		속성 종류
		- ALL: 모두 적용
		- PERSIST: 영속
		- REMOVE: 삭제
		- MERGE: 병합
		- REFRESH: 갱신? 새로고침? 초기화?
		- DETACH: 분리
		
		ex) @OneToMany(cascade = CascadeTyep.ALL)

	- orphanRemoval : 고아 객체 제거 여부
		- true
		- false
		- 고아 객체 제거 : 부모 엔티티와의 **관계가 끊어진 자식 엔티티를 자동으로 삭제**하는 기능
			@OneToMany(orphanRemoval = true)
			- fetch: 연관된 엔티티의 로딩 전략을 설정
				- FetchType.EAGER : 처음 가져올 때 다 가져옴
				- FetchType.LAZY: 실행할 때마다 가져옴
				ex)  @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, orphanRemoval = true)

### 일대일 (1:1)
- `@OneToOne` 을 활용해 관계를 명시한다.
- 반대편도 일대일 관계를 가지며, 주 테이블이나 대상 테이블 중에 외래키 선택 가능하다.

### 다대다 (M:N)
- `@ManyToMany` 을 활용해 관계를 명시한다.
- 실무에서 사용하지 않는 것을 권장한다.
- 대신, 중간 엔티티를 만들어서 일대다, 다대일 관계로 만든다.

### 연관관계 매핑시 주의할 점

- 연관 관계는 단방향만으로 충분하며, 양방향의 경우 역참조가 발생할때 작성
- **양방향 매핑시 무한루프를 조심**
    - toString(), lombok, JSON 생성 라이브러리 등
- 엔티티를 API 응답으로 직접 반환하지 않음
- **컬렉션은 필드에서 초기화하는 것이 안전**