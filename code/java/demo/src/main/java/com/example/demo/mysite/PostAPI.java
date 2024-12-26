package com.example.demo.mysite;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostAPI {
//    여러 게시글을 가지고 있을 리스트 생성
    List<Post> posts = new ArrayList<>();

//    게시글 생성에서 id 생성을 위한 장치
    private Long id = 0L;

    {
//        인스턴스가 생성되었을 때 한번 실행된다.
//        초기값을  넣을 때 사용
        posts.add(new Post(++id, "제목", "내용"));
    }

//    CRUD

//    create
//  게시글 생성을 위한 메서드 필요
//  해당 페이지 url 필요
    @GetMapping("/posts/creates")
    public Post createPost() {
        Post post = new Post(++id, "제목", "내용");
        posts.add(post);
        return post;
    }

//    read
//    게시글 전체 조회
    @GetMapping("/posts")
    public List<Post> readPosts(){
        return posts;
    }

//    read
//   단일 조회
    @GetMapping("/posts/{id}")
//    public Post readPostById(@PathVariable("id") Long id) {
//    url의 {변수}명과 parameter 변수명이 일치할 경우 @PathVariable에 명시하지 않아도 자동 매칭됨
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
    @GetMapping("/posts/{id}/update")
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
    @GetMapping("/posts/{id}/delete")
    public Post deleatePost(@PathVariable Long id) {
        for(Post post : posts) {
            if (post.getId().equals(id)) {
                posts.remove(post);
            }
        }
        return null;
    }


}
