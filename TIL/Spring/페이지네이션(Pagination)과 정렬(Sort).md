## 페이징
: 데이터를 **일정한 크기로 나누어 필요한 부분만 가져오는 것**
- 데이터베이스에서 대량의 데이터를 조회할 때, 모든 데이터를 한 번에 가져오면 성능 문제가 발생할 수 있음
- `JpaRepository`의 메서드에 `Pageable`을 parameter로 넣으면 사용 가능
```java
@GetMapping("/articles")
public Page<Article> getArticles(Pageable pageable) {
    return articleService.getArticles(pageable);
}
```
### `Pageable`
: 페이징 된 데이터의 결과를 담는 interface
- 실제 데이터 외에도 페이징 처리에 필요한 다양한 정보를 제공
속성
- page: 페이지 번호 (0부터 시작) 
- size: 페이지 크기
- sort: 정렬 방식 
    - 필드명, 정렬방식 으로 사용
	    ex) sort=createdAt, desc
    - 존재하지 않는 필드를 사용하면 `PropertyReferenceException`을 throw
메서드
- **getTotalPages() 전체 페이지 수**
- getTotalElements()  전체 데이터 수
- **getContent();  현재 페이지의 데이터**
- **hasNext() 다음 페이지 존재 여부**
- hasPrevious() 이전 페이지 존재 여부
- **isFirst() 현재 페이지가 첫 페이지인지**
- **isLast() 현재 페이지가 마지막 페이지인지**

### Pageable 관련 설정

- `application.properties`
```java
# 페이지 번호를 1부터 시작할지 여부
spring.data.web.pageable.one-indexed-parameters=true

# 한번에 가져올 수 있는 최대 데이터 개수
spring.data.web.pageable.max-page-size=100
```
    
- 기본 값 설정 
    - `@PageableDefault`
        : 특정 API에만 기본값을 적용하고 싶을 때 사용
	
```java
@GetMapping("/articles")
public Page<Article> getArticles(
	@PageableDefault(
		size = 20,                           // 페이지당 20개
		sort = "createdAt",                  // createdAt 필드로 정렬
		direction = Sort.Direction.DESC       // 내림차순
	) Pageable pageable
) {
	return articleService.getArticles(pageable);
}
	```
또는`application.properties`에 추가 가능
```java
# 페이지당 기본 데이터 개수
spring.data.web.pageable.default-page-size=20
```

### 고려 사항
#### 페이지 크기(size) 제한
- application.properties에서 설정한 최대 값보다 큰 요청이 올 경우
	- 설정값으로 제한하여 처리하거나 exception을 throw
#### 페이지 번호(page) 검증
- 잘못된 페이지 번호 요청 시 exception을 throw
	- 음수 값 (-1, -2, ...)
	- 전체 페이지 수를 초과하는 값
	- 숫자가 아닌 값 ("abc", "한글", ...)
#### 정렬(sort) 제한
- **보안상 정렬하면 안 되는 필드 제한 (password 등)**
- **성능상 정렬이 부담되는 필드 제한 (큰 용량의 content 등)**
- DB 인덱스가 없는 필드의 정렬 제한

#### OneToMany에서의 paging
**`OneToMany` 관계에서 `paging`과 `fetch join`을 함께 사용하면 안됨**
    
- 데이터가 예상과는 다르게 올 수 있다.
	- **1번 게시글에 댓글이 2개 / 2번 게시글에 댓글이 2개**
		인 상황에서 `size=2` 의 요청을 보내면
		
		- **1, 2번 게시글을 가져옴**
		- 1번 게시글의 댓글이 2개이기 때문에 2개의 record에 대한 정보인 **게시글 1번만 가져옴**
		=> 두 가지의 경우가 있을 수 있음
			최근 버전은 이를 자동적으로 해결해주나, memory상에서 처리하기 때문에 좋지 못함
		=> batch size를 조절하는 방식으로 `N+1` 문제를 개선 가능
        
- `ManyToOne` 에서는 사용해도 문제가 발생하지 않음

### Batch Size
: 연관 데이터를 하나씩 쿼리하지 않고 **배치 사이즈만큼 묶어서 한번에 가져오는 방식**

**글로벌 설정** (application.properties):
```Java
hibernate.default_batch_fetch_size=5
```
**개별 설정(어노테이션)**
```Java
@BatchSize(size = 5)
@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
private List<Order> orders;
```

### ex) 10명의 멤버의 주문 수 조회
```Java
List<Member> members = memberRepository.findAll(); // Member 10개 조회
for (Member member : members) {
    System.out.println(member.getOrders().size()); // 각 Member의 Order 조회
}
```

### 배치 사이즈 설정하지 않은 경우
- Member 조회
	`SELECT * FROM Member;  
		=> Member 전체 조회 
		=> 1개의 쿼리

- Member당 Order 조회
	`SELECT * FROM Order WHERE member_id = ?;` 
		=> Order 전체 조회 => 1개의 쿼리 * 멤버 수
		=> 1 * 10 =10개의 쿼리

총 11개의 쿼리 실행 발생 => DB 접근 증가 => 성능 저하


### 배치 사이즈 설정한 경우
- Member 조회
	`SELECT * FROM Member;` 
	 => Member 전체 조회 => 1개의 쿼리

- Member당 Order 조회
	**`SELECT * FROM Order WHERE member_id IN (?,?,?,?,?);`**
		=> 배치사이즈 만큼의 멤버 수 Order 전체 조회 => 1개의 쿼리 
		=> 멤버수/배치사이즈 = 총 Order 조회 쿼리 수
		=> 10/5 = 2개의 쿼리 

총 3개의  쿼리 실행 발생 => DB 접근 감소 => 성능 향상

