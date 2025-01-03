package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.*;
import com.example.demo.myjpasitev4.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
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

// @ControllerAdvice 해서 Controller에 직접적으로 추가할 필요 없음
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(ResourceNotFoundException ex) {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(ApiResponse.error("resoure not found", "NOT_FOUND"));
//    }

//    @PostMapping
//    public PostResponseDto createPost(@RequestBody PostCreateRequestDto requestDto) {
//        return postServiceV4.createPost(requestDto);
//    }

    @PostMapping
//    ResponseEntity
//    - Spring Framework에서 HTTP 응답을 상세하게 제어할 수 있게 해주는 클래스
//    - HTTP Status Code, Headers, Body 등을 직접 제어하여 클라이언트에게 더 명확한 응답을 전달 가능
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@Valid  @RequestBody PostCreateRequestDto requestDto){
        ResponseEntity<ApiResponse<PostResponseDto>> body = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok(
                                "게시글이 정상적으로 작성되었습니다",
                                "CREATED",
                                postServiceV4.createPost(requestDto)
                        )
                );
        return body;
    }

//    @GetMapping
//    public List<PostListResponseDto> readPosts() {
//        return postServiceV4.readPosts();
//    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts() {
        List<PostListResponseDto> data = postServiceV4.readPosts();
        ApiResponse<List<PostListResponseDto>> response = ApiResponse.ok(data);
        return ResponseEntity.ok(response);

    }

//    @GetMapping("/{id}")
//    public PostResponseDto readPostById(Long id) {
//        return postServiceV4.readPostById(id);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> readPostById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.ok(postServiceV4.readPostById(id)));
    }


//    @PutMapping("/{id}")
//    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
//        return postServiceV4.updatePost(id, requestDto);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return ResponseEntity.ok(ApiResponse.ok(postServiceV4.updatePost(id, requestDto)));
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deletePost(@PathVariable Long id) {
//        postServiceV4.deletePost(id);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id){
        postServiceV4.deletePost(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "게시글이 정상적으로 삭제되었습니다",
                        "DELETED",
                        null
                )
        );
    }


}
