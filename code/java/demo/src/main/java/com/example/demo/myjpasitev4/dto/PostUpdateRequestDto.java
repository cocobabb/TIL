package com.example.demo.myjpasitev4.dto;

import lombok.Getter;

@Getter
//@NoArgsConstructor
public class PostUpdateRequestDto {
//    업데이트 게시물의 작성자가 바뀌는 것은 이상하니 제목, 컨텐츠에 대해서만 처리
        private String title;
        private String content;


}
