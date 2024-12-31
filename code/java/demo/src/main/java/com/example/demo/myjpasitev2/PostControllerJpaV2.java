package com.example.demo.myjpasitev2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpaV2/posts")
@RequiredArgsConstructor // 생성자
public class PostControllerJpaV2 {
    private final PostServiceJpaV2 postServiceJpaV2;

//    public PostControllerJpa(PostServiceJpaV2 postServiceJpaV2) {
//        this.postServiceJpaV2 = postServiceJpaV2;
//    }

    @PostMapping
    public PostJpaV2 createPost(@RequestBody PostJpaV2 postJpa) {
        return postServiceJpaV2.createPost(postJpa);
    }

    @GetMapping
    public List<PostJpaV2> readPosts() {
        return postServiceJpaV2.readPost();
    }

    @GetMapping("/{id}")
    public PostJpaV2 readPostById(@PathVariable Long id) {
        return postServiceJpaV2.readPostById(id);
    }

    @PutMapping("/{id}")
    public PostJpaV2 updatePost(@PathVariable Long id, @RequestBody PostJpaV2 updatePostJpa) {
        return postServiceJpaV2.updatePost(id, updatePostJpa);
    }
}
