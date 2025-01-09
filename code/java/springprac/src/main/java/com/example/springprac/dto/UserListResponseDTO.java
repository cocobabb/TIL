package com.example.springprac.dto;

import com.example.springprac.User;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserListResponseDTO {
    private final Long id;

    private final String username;
    private final String email;
    private final String nickname;
    private final Integer age;
    private final Boolean isActive;

    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static UserListResponseDTO from(User entity) {
        return UserListResponseDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .nickname(entity.getNickname())
                .age(entity.getAge())
                .isActive(entity.getIsActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

}
