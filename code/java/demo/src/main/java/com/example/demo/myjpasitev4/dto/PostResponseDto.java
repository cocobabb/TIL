package com.example.demo.myjpasitev4.dto;

import com.example.demo.myjpasitev4.PostV4;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {
    private final Long id;

    private final String title;
    private final String content;
    private final String author;

//    정적 팩토리 메서드 패턴
//    생성자 대신 static 메서드를 통해 객체를 생성(객체 생성을 캡슐화)
    public static PostResponseDto from(PostV4 entity) {

        return PostResponseDto.builder()
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .id(entity.getId())
                .content(entity.getContent())
                .build();
    }

}
