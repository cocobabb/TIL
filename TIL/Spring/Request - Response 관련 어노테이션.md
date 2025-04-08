### 요청(Request) 관련 어노테이션

#### @PathVariable
: **URL 경로에서 변수를 추출**할 때 사용
 주요 속성
- `required` (기본값: true. false를 사용할 일은 거의 없음)
ex)
```Java
@GetMapping("/{id}")
public Post readPostById(@PathVariable Long id){
    for (Post post : posts) {
        if (post.getId().equals(id)) {
            return post;
        }
    }
    return null;
 }
```


#### @RequestBody
: HTTP 요청 본문(Body)을 자바 객체로 변환할 때 사용  
- **주로 POST, PUT, PATCH 요청에서** JSON **데이터를 전달받을 때** 사용
- 특징
    - **Content-Type이 application/json인 경우에만 동작**
    - required 속성으로 필수 여부 지정 가능 (기본값: true)
ex)
```Java
@PostMapping
public Post createPost(@RequestBody Post newPost){
    String title = newPost.getTitle();
    String content = newPost.getContent();
    Post post = new Post(++id, title, content);
    
    posts.add(post);
    
    return post;
}
```


### @RequestParam
: URL 쿼리 파라미터를 추출할 때 사용
- 주요 속성
	- required: 필수 여부 (기본값: true)
    - defaultValue: 기본값 설정, 기본값 설정 시 required의 여부와 상관 없이 사용 가능
ex)
```Java
@GetMapping("/paged")
public List<Post> getPagedPosts(@RequestParam int page, @RequestParam int size){
// 1. 페이지네이션을 위한 더미데이터 추가
    for (int i = 1; i <= 20; i++) {
	    String title = "제목 " + i;
        String content = "내용 " + i;
        Post post = new Post(++id, title, content);
        posts.add(post);
    }
    
// 2. 시작 인덱스와 끝 인덱스 계산
    int startIndex = (page - 1) * size;
    int endIndex = Math.min(startIndex + size, posts.size());
    
// 3. 페이지에 해당하는 데이터만 추출
    return posts.subList(startIndex, endIndex);
        }
```

기본값이 있는 경우
```Java
@GetMapping("/paged")
public List<Post> getPagedPosts(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
) {
```


### @ModelAttribute
: 요청 파라미터를 객체로 바인딩할 때 사용
- 주로 Form 데이터를 전달받을 때 사용
- 특징
    - Content-Type
        - application/x-www-form-urlencoded : 일반 텍스트 데이터
        - **multipart/form-data : 파일을 포함한 데이터**
	    인 경우 사용 가능    
    - 또는 Query Parameters도 받을 수 있음
        

### 응답(Response) 관련 어노테이션

### @ResponseBody
: 자바 객체를 HTTP 응답 본문으로 변환할 때 사용
- **@RestController를 사용하면 생략 가능**
- 특징
    - 기본적으로 **JSON 형태로 변환**됨

### @ResponseStatus
: HTTP 응답 상태 코드를 지정할 때 사용
- 주요 상태 코드
    - 200 OK: 요청 성공
    - 201 Created: 리소스 생성 성공
    - 204 No Content: 요청 성공했지만 응답 데이터 없음
    - 400 Bad Request: 잘못된 요청
    - 401 Unauthorized
	- 403 Forbidden : 콘텐츠에 접근할 권리 없음
		401과 다른 점: 클라이언트가 인증(Authentication)된 상태고 권한(Authorization)은 없는 것
	- 404 Not Found: 리소스를 찾을 수 없음
ex)
```Java
import org.springframework.http.HttpStatus;

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Post createPost(@RequestBody Post newPost){
	String title = newPost.getTitle();
    String content = newPost.getContent();
    Post post = new Post(++id, title, content);
    posts.add(post);
    return post;
}
```