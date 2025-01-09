package com.example.springprac.dto;

import lombok.Getter;

@Getter
public class UserUpdateRequestDTO {
    private String email;
    private String nickname;
    private Integer age;
}
