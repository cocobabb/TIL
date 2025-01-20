package com.example.relation.domain.post.dto.request;

import com.example.relation.domain.post.entity.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRequestDto {

    @NotBlank()
    @Length(max = 20)
    @Schema(description = "제목", example = "게시글 제목")
    private String title;

    @NotBlank
    @Length(min = 5)
    @Schema(description = "내용", example = "게시글 내용")
    private String content;

    @Length(min = 2, max = 10)
    private String author;

    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .build();
    }
}