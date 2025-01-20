package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.post.dto.request.Post2CreateWithAuthorRequestDto;
import com.example.relation.domain.post.dto.request.Post2ResponseDto;
import com.example.relation.domain.post.dto.request.PostCreateRequestDto;
import com.example.relation.domain.post.dto.request.PostUpdateRequestDto;
import com.example.relation.domain.post.dto.response.*;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.PostTag;
import com.example.relation.domain.post.repository.Post2Repository;
import com.example.relation.domain.post.repository.PostRepository;
import com.example.relation.domain.post.repository.PostTagRepository;
import com.example.relation.domain.tag.Tag;
import com.example.relation.domain.tag.TagRepository;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.global.common.service.FileService;
import com.example.relation.global.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
// @Sl4j
// : console.log() 대신 로깅을 쓰면 사용자에게 정보를 노출시기키지 않고도  애플리케이션의 동작 상태와 문제점을 파악하기 위해 정보를 기록할 수 있음
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;
    private final PostTagRepository postTagRepository;
    private final FileService fileService;
    private final Post2Repository post2Repository;


    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        Post post = postRepository.save(requestDto.toEntity());
        return PostResponseDto.from(post);
    }

    public List<PostListResponseDto> readPosts(){
        log.info("read posts");
        return postRepository.findAll().stream()
                .map(PostListResponseDto::from)
                .toList();
    }

    public PostWithCommentResponseDto readPostById(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        List<Comment> comments = commentRepository.findByPostId(id);
        log.info("read posts {}", id);
        return PostWithCommentResponseDto.from(post, comments);
    }

    public PostWithCommentResponseDtoV2 readPostByIdV2(Long id) {
//        post와 댓글을 한번에 가져오고 싶음
        Post post = postRepository.findByIdWithComment(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        return PostWithCommentResponseDtoV2.from(post);
    }
    
    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        post.update(requestDto);

        return PostResponseDto.from(post);
    }

    @Transactional
    public void deletePost(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        postRepository.delete(post);
    }

//  게시글 가져올 때 댓글 수 가져오기1(Normal)
    public List<PostListWithCommentCountResponseDto> readPostsWithCommentCount(){
        List<Object[]> results =  postRepository.findAllWithCommentCount();
        return results.stream()
                .map(result -> {
                    Post post = (Post) result[0];
                    Long commentCount = (Long) result[1];
                    return new PostListWithCommentCountResponseDto(
                            post.getId(),
                            post.getTitle(),
                            post.getCreatedAt(),
                            commentCount);
                }).toList();
    }
//  게시글 가져올 때 댓글 수 가져오기2(DTO in JPQL)
    public List<PostListWithCommentCountResponseDto> readPostsWithCommentCountDto() {
        return postRepository.findAllWithCommentCountDTO();
    }

//    게시물과 태그 중계 테이블을 만들자
    @Transactional
    public void addTagToPost(Long id, @Valid TagRequestDto requestDto) {
//      id를 통해서 post를 가져오자
        Post post = postRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException());

//      requestDto의 name을 통해서 tag를 가져오자
        Tag tag = tagRepository.findByName(requestDto.getName())
                .orElseThrow(()->new ResourceNotFoundException());

        PostTag postTag = new PostTag();
        postTag.addTag(tag);
        postTag.addPost(post);

        postTagRepository.save(postTag);

        post.getPostTags().add(postTag);
    }
//  게시글, 댓글들, 태그들 다 가져오기
    public PostWithCommentAndTagResponseDto readPostsByIdWithCommentAndTag(Long id){

//        Post post = postRepository.findByIdWithCommentAndTag(id)
//                .orElseThrow(() -> new ResourceNotFoundException());
//        return PostWithCommentAndTagResponseDto.from(post);
//        =>문제: 포스트맨 실행 시 오류 MultipleBagFetchException: cannot simultaneously fetch multiple bags => 카테시안 곱 문제

//      카테시안 곱 문제 해결: 게시글과 tag를 함께 가져오고 댓글을 따로 가져와서 DTO에서 합침
        Post postWithTag = postRepository.findByIdWithTag(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        List<Comment> comments = commentRepository.findByPostId(id);

        return PostWithCommentAndTagResponseDto.from(postWithTag, comments);
    }

    // 카테시안 곱 문제 해결: fetch 와  batch 해결(쿼리문 많이 나가기 때문에 쿼리문에 DISTINCT 처리)
    public PostWithCommentAndTagResponseDtoV2 readPostsByIdWithCommentAndTagV2(Long id) {
        Post post = postRepository.findByIdWithCommentAndTagV2(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        return PostWithCommentAndTagResponseDtoV2.from(post);
    }

    //    전체 게시글의 댓글들과 태그들을 함께 조회
    public List<PostWithCommentAndTagResponseDtoV2> readPostsDetail() {
        return postRepository.findWithCommentAndTag()
                .stream().map(
                        PostWithCommentAndTagResponseDtoV2::from
                ).toList();
    }
// 태그로 검색하여 특정 태그를 가진 게시글의 댓글들과 태그들을 함께 조회
    public List<PostWithCommentAndTagResponseDtoV2> readPostsByTag(String tag) {
        return postRepository.findAllByTagName(tag)
                .stream().map(
                        PostWithCommentAndTagResponseDtoV2::from
                ).toList();
    }
//    해당 페이지번호에 있는 게시글 목록 조회
//    Pageable: 페이징 된 데이터의 결과를 담는 interface => 페이징에 필요한 정보를 담고 있음
//    page: 페이지 번호 0부터 시작, size: 페이지 크기(한 페이지당 요소가 들어갈 갯수), 정렬 방식 - sort)
//    쿼리문에 위와 같은 변수명으로 값 받아서 처리됨
    public List<PostResponseDto> readPostsWithPage(Pageable pageable) {
       return postRepository.findAll(pageable)
                .getContent()
                .stream().map(
                        PostResponseDto::from
                ).toList();
    }

//    페이지 정보를 가진 해당 페이지 번호에 있는 게시글 목록
    public PostListWithPageResponseDto radPostWithPageDetail(Pageable pageable) {
        return PostListWithPageResponseDto.from(
                postRepository.findAll(pageable)
        );
    }

//    페이지번호와 게시물 정보 전체를 가진 게시글 목록 조회
    public List<PostWithCommentAndTagResponseDtoV2> readPostsWithCommentPage(Pageable pageable) {
        return postRepository.findPostsWithCommentPage(pageable)
                .getContent()
                .stream().map(
                        PostWithCommentAndTagResponseDtoV2::from
                ).toList();
    }


//  게시물 생성 시 사진도 포함해서 생성 가능
    @Transactional
    public PostWithImageResponseDto createPostWithImage(PostCreateRequestDto requestDto, MultipartFile image){

        String imageUrl = null;
        if(image != null && !image.isEmpty()) {
            imageUrl = fileService.saveFile(image);
        }

        Post post = requestDto.toEntity();
        post.setImageUrl(imageUrl);

        return PostWithImageResponseDto.from(
                postRepository.save(post)
        );
    }

    @Transactional
    public Post2ResponseDto createPost2(Post2CreateWithAuthorRequestDto requestDto, User user) {
        return Post2ResponseDto.from(
                post2Repository.save( requestDto.toEntity(user))
        );
    }
}
