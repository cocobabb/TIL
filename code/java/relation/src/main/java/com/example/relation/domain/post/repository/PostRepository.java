package com.example.relation.domain.post.repository;

import com.example.relation.domain.post.dto.PostListWithCommentCountResponseDto;
import com.example.relation.domain.post.entity.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p LEFT JOIN p.comments WHERE p.id = :id")
    Optional<Post> findByIdWithComment(@Param("id") Long id);

    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.comments WHERE p.id = :id")
    Optional<Post> findByIdWithCommentFetch(@Param("id") Long id);

    //    N+1문제 해결 => JOIN FETCH
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.comments")
    List<Post> findAllWithCommentFetch();

//  "SELECT p FROM Post p LEFT JOIN FETCH p.comments"
//  을 통해 join 처리했던 것을 @EntityGraph로 간단하게 처리 가능
//    @EntityGraph: attributePaths에 바로 fetch join할 속성 지정
    @EntityGraph(attributePaths = {"comments"})
    @Query("SELECT p FROM Post p")
    List<Post> findAllWithCommentEntityGraph();

//    게시글 가져올 때 댓글 수 가져오기1(Normal)
    @Query("SELECT p, COUNT(c) " +
            "FROM Post p " +
            "LEFT JOIN p.comments c " +
            "GROUP BY p")
    List<Object[]> findAllWithCommentCount();

//  게시글 가져올 때 댓글 수 가져오기2(DTO in JPQL)
    @Query("SELECT new com.example.relation.domain.post.dto.PostListWithCommentCountResponseDto(p.id, p.title, p.createdAt, COUNT(c)) " +
            "FROM Post p " +
            "LEFT JOIN p.comments c " +
            "GROUP BY p")
    List<PostListWithCommentCountResponseDto> findAllWithCommentCountDTO();

//     엔티티상으로는 특정 게시글에서 댓글들과 태그들을 가져오는게 문제가 되지않지만 해당 데이터들을 쿼리문을 통해서 가져오는데 해당 쿼리문은 카테시안곱 문제가 일어나고 있음
    @Query("SELECT p FROM Post p " +
            "LEFT JOIN FETCH p.comments c " +
            "LEFT JOIN FETCH p.postTags pt " +
            "LEFT JOIN FETCH pt.tag " +
            "WHERE p.id = :id")
    Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);

// 해결: 게시글과 태그들까지만 같이 가져오고 댓글은 따로 가져와서 Dto상에서 합침
    @Query("SELECT p FROM Post p " +
            "LEFT JOIN FETCH p.postTags pt " +
            "LEFT JOIN FETCH pt.tag " +
            "WHERE p.id = :id")
    Optional<Post> findByIdWithTag(@Param("id") Long id);

    @Query("SELECT DISTINCT p FROM Post p " +
            "LEFT JOIN p.comments c " +
            "LEFT FETCH JOIN p.postTags pt " +
            "LEFT FETCH JOIN pt.tag " +
            "WHERE p.id = :id")
    Optional<Post> findByIdWithCommentAndTagV2(@Param("id") Long id);
}
