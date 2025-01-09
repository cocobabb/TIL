package com.example.demo.myjpasitev4.dto;

import com.example.demo.myjpasitev4.PostV4;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostListResponseDto {

    private final Long id;

    private final String title;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    //  생성자 대신 static 메서드를 통해 객체를 생성(객체 생성을 캡슐화)
    public static PostListResponseDto from(PostV4 entity) {

        return PostListResponseDto.builder()
                .title(entity.getTitle())
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
