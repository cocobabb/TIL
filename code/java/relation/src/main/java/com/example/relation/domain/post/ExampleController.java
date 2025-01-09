package com.example.relation.domain.post;

import com.example.relation.domain.post.dto.PostWithCommentResponseDtoV2;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {
    private  final PostRepository postRepository;

    @GetMapping("/basic/{postId}")
    public void LoadingExample1(@PathVariable Long postId){
        Post post = postRepository.findById(postId).orElseThrow();
//        List<Comment> comments = post.getComments();

//        문제점: 쿼리가 2번 반복됨 => DB
//        해결: 해당 엔티티의 필드의 fetchType을 eager로 하여(한번 쿼리를 불러 올 때 데이터를 다 가져옴) 댓글들 데이터를 불러오거나
//             fetch join하여 댓글들 데이터를 가져오거나
        int commentSize = post.getComments().size();
    }

    @GetMapping("/fetch/{postId}")
    public void LoadingExample2(@PathVariable Long postId){
//       repository에서 @Query로 댓글들을 join해줌
        Post post = postRepository.findByIdWithCommentFetch(postId).orElseThrow();
        int commentSize = post.getComments().size();
    }

    @GetMapping("/nplus1/basic")
    public void LoadingExample3(){
//        문제: 게시물의 댓글 수(N)만큼 쿼리문이 날라감
//        => 게시물 가져오는 쿼리 1개만 발생할 줄 알았는데 댓글 수(N) + 원래 예상한 쿼리 수(1) 개 발생함
//        => N+1 Problem
        List<Post> posts  =postRepository.findAll();
        posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
    }

//    N+1 Problem 해결방법1
    @GetMapping("/nplus1/fetch")
    public void LoadingExample4(){
        List<Post> posts  =postRepository.findAllWithCommentFetch();
        posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
    }

//    N+1 Problem 해결방법2
    @GetMapping("/nplus1/entity-graph")
    public void LoadingExample5(){
        List<Post> posts  =postRepository.findAllWithCommentEntityGraph();
        posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
    }
}
