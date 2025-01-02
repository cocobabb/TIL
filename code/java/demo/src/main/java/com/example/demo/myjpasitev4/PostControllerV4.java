package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v4/posts")
@RequiredArgsConstructor // 생성자
public class PostControllerV4 {
    private final PostServiceV4 postServiceV4;

    @PostMapping
    public PostResponseDto createPost(@RequestBody PostCreateRequestDto requestDto) {
        return postServiceV4.createPost(requestDto);
    }

    @GetMapping
    public List<PostListResponseDto> readPosts() {
        return postServiceV4.readPosts();
    }

    @GetMapping("/{id}")
    public PostResponseDto readPostById(Long id) {
        return postServiceV4.readPostById(id);
    }

    @PutMapping("/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postServiceV4.updatePost(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postServiceV4.deletePost(id);
    }


}
