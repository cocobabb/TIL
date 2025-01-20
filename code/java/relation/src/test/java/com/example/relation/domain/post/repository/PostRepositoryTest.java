package com.example.relation.domain.post.repository;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.dto.PostListWithCommentCountResponseDto;
import com.example.relation.domain.post.entity.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
//    생성자 DI (필드 주입)
    private  PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    private Post post;
    private Comment comment1;
    private Comment comment2;

    @BeforeEach
    void setUp() {
        post = new Post("테스트 제목", "테스트 내용", "테스트 작성자");
        post = postRepository.save(post);

        comment1 = new Comment("댓글1", post);
        comment2 = new Comment("댓글2", post);
        commentRepository.save(comment1);
        commentRepository.save(comment2);
    }

    @Test
    void findByIdWithComment_성공() {
//        given => post, comment가 db에 존재하는 상황

//        when => 내가 post를 findBy~ 했을 때, 그 결과가
        Optional<Post> foundPost = postRepository.findByIdWithComment(post.getId());

//        then
//        여기서 검증되었으면 좋겠음
//        1. post가 존재함
        Assertions.assertThat(foundPost).isPresent();
//        Assertions.assertThat(foundPost).isEmpty();

//        2. post에 대한 comment가 2개 존재함
        Assertions.assertThat(foundPost.get().getComments()).hasSize(2);

//        3. post에 대한 comment 중 첫번째의 content가 "댓글1"이다
        Assertions.assertThat(
                foundPost.get().getComments().getFirst().getContent()
        ).isEqualTo("댓글1");
    }
        @Test
        void findAllWithCommentCountDTO_성공 () {
//            then
            List<PostListWithCommentCountResponseDto> results =
                    postRepository.findAllWithCommentCountDTO();

//            너는 리스트인데 게시물이 하나 들어있을 거야
            Assertions.assertThat(results).hasSize(1);

//        거기에 들어있는 게시물의 결과 값에  게시물 아이디가 들어있을 거 같아
            Assertions.assertThat(results.getFirst().id())
                    .isEqualTo(post.getId());

//        너의 댓글 수에는 2가 들어있어야 해
            Assertions.assertThat(
                            results.getFirst().commentCount()
                    ).isEqualTo(2L);
        }

        @Test
        void findAllByTagName_없는_태그_검색 () {
//        given
            String notExitstTag = "존재하지 않는 태그";
//        when
            List<Post> posts = postRepository.findAllByTagName(notExitstTag);

//        then
            Assertions.assertThat(posts).isEmpty();
        }

    }