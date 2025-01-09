package com.example.springprac;

import com.example.springprac.dto.UserUpdateRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String nickname;
    private Integer age;

    @Column(nullable = false)
    private Boolean isActive;

    @Builder
    public User(String username, String email, String nickname, Integer age) {
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.age = age;
        this.isActive = true;
    }

    public User update (UserUpdateRequestDTO requestDTO) {
        this.email = requestDTO.getEmail();
        this.nickname = requestDTO.getNickname();
        this.age = requestDTO.getAge();
        return this;
    }
}
