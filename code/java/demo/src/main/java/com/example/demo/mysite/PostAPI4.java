package com.example.demo.mysite;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v4/posts")
public class PostAPI4 {
//    여러 게시글을 가지고 있을 리스트 생성
    List<Post> posts = new ArrayList<>();

//    게시글 생성에서 id 생성을 위한 장치
    private Long id = 0L;

    {
//        초기화 블럭
//        인스턴스가 생성되었을 때 한번 실행된다.
//        초기값을 넣을 때 사용
        posts.add(new Post(++id, "제목", "내용"));
    }

//    CRUD

//    create
//  게시글 생성을 위한 메서드 필요
//  해당 페이지 url 필요
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post newPost) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());

        String title = newPost.getTitle();
        String content = newPost.getContent();


        if(title == null || title.isBlank()){
            throw new RuntimeException("title을 입력해주세요");
        }

        if(content == null || content.isBlank()){
            throw new IllegalArgumentException("content를 입력하시오");
        }

//        Post post = new Post(++id, "제목", "내용");
        Post post = new Post(++id,title, content);
        posts.add(post);
        return post;
    }

//    read
//    게시글 전체 조회
    @GetMapping
    public List<Post> readPosts(){
        return posts;
    }

//    read
//   단일 조회
    @GetMapping("/{id}")
    public Post readPostById(@PathVariable Long id) {
//        posts 에서 post를 가져오기
        for(Post post : posts) {
            if(post.getId().equals(id)) {
                return post;
            }
        }
        return null;
    }

//    update
    @PutMapping("/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post updatePost) {

        String newTitle = updatePost.getTitle();
        String newContent = updatePost.getContent();

        for(Post post : posts) {
            if (post.getId().equals(id)) {
                post.setTitle(newTitle);
                post.setContent(newContent);
                return post;
            }
        }
        return  null;
    }
//    delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Post deleatePost(@PathVariable Long id) {
        Post removedPost = null;
        for(Post post : posts) {
            if (post.getId().equals(id)) {
                removedPost = post;
                break;
            }
        }
        posts.remove(removedPost);
        return null;
    }

    @GetMapping("/paged")
    public List<Post> getPagedPosts(
//            @RequestParam int page,
//            @RequestParam int size
//            문제점: @RequestParam 은 required(필수 여부)가 true
//            => mapping된 uri에 파라미터를 2개 받기로 되어있는데 값이 안들어 오면 에러남("status":400, "error": "Bad Request")
            
//            해결방법: 아래와 같이 기본값을 가지도록 해서 값이 안들어올 경우 기본값으로 처리 되도록 함
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
            ) {
//        페이지네이션을 위한 더미 데이터 추가
            for(int i = 1; i <= 20; i++){
                String title = "제목" + i;
                String content = "내용" + i;

                Post post = new Post(++id, title, content);
                posts.add(post);
            }

            int startIdx = (page -1) * size;
            int endIdx = Math.min(startIdx + size, posts.size());

            return posts.subList(startIdx, endIdx);
    }

    @GetMapping("/temp")
    public String temp(@RequestParam(defaultValue = "normalHaha") String haha, String kiki){
        System.out.println(haha);
        System.out.println(kiki);
        return haha;
    }

//   클라이언트가 요청 보낸 HTTP method에 따라서 해당하는 메서드로 빠지기 때문에 같은 uri여도 같은 메서드 이름이여도(오버로딩) 다르게 실행됨
    @PostMapping("/temp")
    public int temp(@RequestParam int num){
        System.out.println(num);
        return num;
    }
}
