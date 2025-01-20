package com.example.relation.domain.comment;

import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.comment.dto.CommentRequestDto;
import com.example.relation.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Comment(String content, Post post) {
        this.content = content;
//        this.post = post;
        setPost(post);
    }

    public Comment update(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();
        return this;
    }

    public void setPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }
}
