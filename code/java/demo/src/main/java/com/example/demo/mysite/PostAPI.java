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
//        초기화 블럭
//        인스턴스가 생성되었을 때 한번 실행된다.
//        초기값을 넣을 때 사용
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
        // 반복문에서 Collection framework를 순회할 때 Collection의 iterator가 구조적 변경(Structural Modification)을
        // 감지하여 순회 중 변경이 일어나면 더이상 Collection을 신뢰할 수 없어 ConcurrentModificationException을 던짐 
        // => Collection을 순회할 때 사용하는 iterator는 컬렉션이 변경되지 않을 것을 전제로 설계 되었음
        // => Java의 ConcurrentModificationException 메커니즘은 프로그래머가 컬렉션을 순회하는 동안 안전하지 않은 수정 작업을 감지하여 예외를 던지는 기능
        // => 이를 통해 데이터의 무결성을 유지하고, 개발자가 예상치 못한 문제를 조기에 발견하도록 도움
        Post removedPost = null;
        for(Post post : posts) {
            if (post.getId().equals(id)) {
                removedPost = post;
            }
        }
        posts.remove(removedPost);
        return null;
    }


}
