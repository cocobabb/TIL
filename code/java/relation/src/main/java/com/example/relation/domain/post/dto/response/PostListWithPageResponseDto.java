package com.example.relation.domain.post.dto.response;

import com.example.relation.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostListWithPageResponseDto {
    private List<PostListItemResponseDto> posts;
    private long totalPages;
    private boolean hasNext;
    private boolean hasPrevious;

    public static PostListWithPageResponseDto from(Page<Post> posts) {
        return PostListWithPageResponseDto.builder()
                .posts(posts.getContent()
                        .stream().map(
                                PostListItemResponseDto::from
                        ).toList()
                )
                .totalPages(posts.getTotalPages())
                .hasNext(posts.hasNext())
                .hasPrevious(posts.hasPrevious())
                .build();
    }
    // 외부 클래스를 import 하던 것을 inner class로 바꿔서 연관된 것들끼리 직관적으로 알 수 있도록 함
    @Getter
    @Builder
    static class PostListItemResponseDto {
        private final Long id;
        private final String title;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;

        public static PostListItemResponseDto from(Post entity){
            return PostListItemResponseDto.builder()
                    .id(entity.getId())
                    .title(entity.getTitle())
                    .createdAt(entity.getCreatedAt())
                    .updatedAt(entity.getUpdatedAt())
                    .build();
        }

    }

}
