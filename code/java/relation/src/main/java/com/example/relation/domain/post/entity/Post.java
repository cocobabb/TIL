package com.example.relation.domain.post.entity;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.post.dto.PostUpdateRequestDto;
import com.example.relation.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private String content;

    @Setter
    private String imageUrl;

    private String author;

//   @OneToMany에 fetch 속성을 설정하지 않으면 기본 값은 아래와 같음
//   fetch = FetChType.LAZY => 실행할 때 마다 가져옴

//    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER) // => 처음 가져올 때 가져옴
    @BatchSize(size = 10)
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> comments;

//    @BatchSize(size = 10)
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<PostTag> postTags;

    @Builder
    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post update(PostUpdateRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        return this;
    }

}