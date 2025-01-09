package com.example.relation.domain.post.dto;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.dto.CommentResponseDto;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.tag.dto.TagResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostWithCommentAndTagResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private final List<CommentResponseDto> comments;
    private final List<String> tags;

    public static PostWithCommentAndTagResponseDto from(Post entity, List<Comment> comments) {
        return PostWithCommentAndTagResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .comments(
//                entity.getComments().stream() // 게시글 가져올 때 태그랑 댓글 다 같이 가져왔을 때
                        comments.stream() // 게시글이랑 태그 같이 가져오고 댓글 가져와서 주입한 경우
                        .map(CommentResponseDto::from)
                        .toList())
                .tags(
                        entity.getPostTags().stream()
                                .map(
                                        postTag -> postTag.getTag().getName()
                                ).toList()
                )
                .build();
    }

}
