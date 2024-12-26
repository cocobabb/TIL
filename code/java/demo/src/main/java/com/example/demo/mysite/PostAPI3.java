package com.example.demo.mysite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v3/posts")
public class PostAPI3 {
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
    public Post createPost() {
        Post post = new Post(++id, "제목", "내용");
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
    public Post update(@PathVariable Long id) {
        for(Post post : posts) {
            if (post.getId().equals(id)) {
                post.setTitle("수정된 제목");
                post.setContent("수정된 내용");
                return post;
            }
        }
        return  null;
    }
//    delete
    @DeleteMapping("/{id}")
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


}
