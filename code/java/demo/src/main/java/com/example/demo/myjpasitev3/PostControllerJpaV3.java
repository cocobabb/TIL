package com.example.demo.myjpasitev3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpaV3/posts")
@RequiredArgsConstructor // 생성자
public class PostControllerJpaV3 {
    private final PostServiceJpaV3 postServiceJpaV3;

//    public PostControllerJpa(PostServiceJpaV2 postServiceJpaV2) {
//        this.postServiceJpaV2 = postServiceJpaV2;
//    }

    @PostMapping
    public PostJpaV3 createPost(@RequestBody PostJpaV3 postJpa) {
        return postServiceJpaV3.createPost(postJpa);
    }

    @GetMapping
    public List<PostJpaV3> readPosts() {
        return postServiceJpaV3.readPost();
    }
//
//    @GetMapping("/{id}")
//    public PostJpaV3 readPostById(@PathVariable Long id) {
//        return postServiceJpaV3.readPostById(id);
//    }
//
//    @PutMapping("/{id}")
//    public PostJpaV3 updatePost(@PathVariable Long id, @RequestBody PostJpaV3 updatePostJpa) {
//        return postServiceJpaV3.updatePost(id, updatePostJpa);
//    }
}
