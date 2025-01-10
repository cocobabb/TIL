package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.PostTag;
import com.example.relation.domain.post.repository.PostRepository;
import com.example.relation.domain.post.repository.PostTagRepository;
import com.example.relation.domain.tag.Tag;
import com.example.relation.domain.tag.TagRepository;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.global.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;
    private final PostTagRepository postTagRepository;

    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        Post post = postRepository.save(requestDto.toEntity());
        return PostResponseDto.from(post);
    }

    public List<PostListResponseDto> readPosts(){
        return postRepository.findAll().stream()
                .map(PostListResponseDto::from)
                .toList();
    }

    public PostWithCommentResponseDto readPostById(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        List<Comment> comments = commentRepository.findByPostId(id);
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
}
