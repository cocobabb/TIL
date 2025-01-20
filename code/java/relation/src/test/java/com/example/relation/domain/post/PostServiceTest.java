package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.comment.CommentService;
import com.example.relation.domain.post.dto.request.PostCreateRequestDto;
import com.example.relation.domain.post.dto.response.PostResponseDto;
import com.example.relation.domain.post.dto.response.PostWithCommentResponseDtoV2;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.repository.PostRepository;
import com.example.relation.global.exception.ResourceNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;  // Mock 객체 생성

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private PostService postService;  // Mock을 주입받는 객체

    @Test
    void createPost_성공() {
        // given
        PostCreateRequestDto requestDto = new PostCreateRequestDto("테스트 제목", "테스트 내용", "테스트 작성자");
        Post post = requestDto.toEntity();
        given(postRepository.save(any(Post.class))).willReturn(post);

        // when
        PostResponseDto result = postService.createPost(requestDto);

        // then

//        result의 title과 입력한 DTO의 title값이 일치하니?
        assertThat(result.getTitle()).isEqualTo("테스트 제목");

//        result의 content와 입력한 DTO의 content값이 일치하니?
        assertThat(result.getContent()).isEqualTo("테스트 내용");

//        해당 레포지토리에서 save 메서드를 호출한게 맞니?
        verify(postRepository).save(any(Post.class));
    }

    @Test
    void readPostByIdV2_성공() {
        // given
        Long postId = 1L;
        Post post = Post.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .author("테스트 작성자")
                .build();

        Comment comment = Comment.builder()
                .content("댓글 내용")
                .post(post)
                .build();

        given(postRepository.findByIdWithComment(postId)).willReturn(Optional.of(post));


        // when
        PostWithCommentResponseDtoV2 result = postService.readPostByIdV2(postId);

        // then
//        result에 결과가 잘 들어갔나?
        assertThat(result).isNotNull();
//        result에 title가 잘 들어갔나?
        assertThat(result.getTitle()).isEqualTo("테스트 제목");
//      result에 content가 잘 들어갔나?
        assertThat(result.getContent()).isEqualTo("테스트 내용");
//        result에 comment를 가지고 있던데 잘 들어갔나?
        assertThat(result.getComments()).hasSize(1);
//        result에 content와 입력한 content가 같나?
        assertThat(result.getComments().getFirst().getContent()).isEqualTo("댓글 내용");
//       레포가 홰당 메서드를 실행한게 맞나?
        verify(postRepository).findByIdWithComment(postId);

    }

    @Test
    void readPostById_실패_게시글이_없는_경우() {
        // given
        Long postId = 999L;
        given(postRepository.findById(postId)).willReturn(Optional.empty());

        // when & then
//
        assertThatThrownBy(() -> postService.readPostById(postId))
                .isInstanceOf(ResourceNotFoundException.class);

//        레포지토리에 해당 함수가 실행되었니?
        verify(postRepository).findById(postId);
//        해당 레포지토리에 해당 함수는 절대 실행 되지않았을 거야
        verify(commentRepository, never()).findByPostId(anyLong());
    }
}