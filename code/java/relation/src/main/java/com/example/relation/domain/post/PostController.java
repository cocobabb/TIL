package com.example.relation.domain.post;

import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@Valid @RequestBody PostCreateRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok("게시글이 성공적으로 작성되었습니다","CREATED",
                                postService.createPost(requestDto)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts() {
        ApiResponse<List<PostListResponseDto>> response = ApiResponse.ok(postService.readPosts());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostWithCommentResponseDto>> readPostById(@PathVariable Long id) {
        ApiResponse<PostWithCommentResponseDto> response = ApiResponse.ok(postService.readPostById(id));
        return ResponseEntity.ok(response);

    }

    @GetMapping("/v2/{id}")
    public ResponseEntity<ApiResponse<PostWithCommentResponseDtoV2>> readPostByIdV2(@PathVariable Long id) {
        ApiResponse<PostWithCommentResponseDtoV2> response = ApiResponse.ok(postService.readPostByIdV2(id));
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        ApiResponse<PostResponseDto> response = ApiResponse.ok("게시글이 성공적으로 수정되었습니다", "UPDATED", postService.updatePost(id, requestDto));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        ApiResponse<Void> response = ApiResponse.ok("게시글이 성공적으로 삭제되었습니다", "DELETED", null);
        return ResponseEntity.ok(response);

    }
    //    게시글 가져올 때 댓글 수 가져오기1(Normal)
    @GetMapping("/comment-count")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostsWithCommentCount() {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsWithCommentCount()
                )
        );
    }
//  게시글 가져올 때 댓글 수 가져오기2(DTO in JPQL)
    @GetMapping("/comment-count-dto")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostsWithCommentCountDto() {
       return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsWithCommentCountDto()
                )
        );
    }
// 게시물과 태그 연결시키기
    @PostMapping("/{id}/tags")
    public void addTagToPost(@PathVariable Long id,
                             @Valid @RequestBody TagRequestDto requestDto){
        postService.addTagToPost(id, requestDto);
    }


    // 특정게시글의 댓글들과 태그들을 함께 조회(게시글과 태그들은 함께, 댓글들은 따로 가져와서 카테시안곱 문제 해결)
    @GetMapping("/{id}/detail")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDto>> readPostsByIdWithCommentAndTag(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsByIdWithCommentAndTag(id)
        ));
    }
    // 특정게시글의 댓글들과 태그들을 함께 조회(fetcch join과 Distinct로 카테시안곱 문제 해결)
    @GetMapping("/{id}/detail/v2")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDtoV2>> readPostsByIdWithCommentAndTagV2(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsByIdWithCommentAndTagV2(id)
        ));
    }

//    전체 게시글의 댓글들과 태그들을 함께 조회
    @GetMapping("/detail")
    public ResponseEntity<ApiResponse<List<PostWithCommentAndTagResponseDtoV2 >>> readPostsDetail(){
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsDetail()
        ));
    }
// 태그로 검색하여 특정 태그를 가진 게시글의 댓글들과 태그들을 함께 조회
    @GetMapping("/tags")
    public ResponseEntity<ApiResponse<List<PostWithCommentAndTagResponseDtoV2>>> readPostsBy(@RequestParam String tag) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsByTag(tag)
                )
        );
    }

//    해당 페이지번호에 있는 게시글  목록 조회
    @GetMapping("/pages")
    public ResponseEntity<ApiResponse<List<PostResponseDto>>> readPostsWithPage(Pageable pageable) {
        return ResponseEntity.ok(
          ApiResponse.ok(
                  postService.readPostsWithPage(pageable)
          )
        );
    }

//    페이지 정보를 가진 해당 페이지 번호에 있는 게시글 목록
    @GetMapping("/pages/detail")
    public ResponseEntity<ApiResponse<PostListWithPageResponseDto>> readPostWithPageDetail(Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.radPostWithPageDetail(pageable)
                )
        );
    }

//   페이지번호와 게시물 정보 전체를 가진 게시글 목록 조회
    @GetMapping("/detail/pages")
    public ResponseEntity<ApiResponse<List<PostWithCommentAndTagResponseDtoV2>>> readPostsWithCommentPage(Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsWithCommentPage(pageable)
                )
        );
    }

//    게시물 생성 시 사진도 포함해서 생성 가능
    @PostMapping("/images")
    public ResponseEntity<ApiResponse<PostWithImageResponseDto>> createPostWithImage(
            @RequestPart(value="data") PostCreateRequestDto requestDto,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.createPostWithImage(requestDto, image)
                )
        );

    }
}





