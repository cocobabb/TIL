package com.example.springprac.dto;

import com.example.springprac.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UserCreatedRequestDTO {
// - username (필수, 중복 불가, 3-20자 제한, 수정 불가)
//- email (필수, 이메일 형식 검증, 중복 불가)
//- nickname (필수, 중복 가능, 2-10자 제한)
//- age (0-150 사이의 정수)
//- isActive (필수, boolean, 기본값 : true)
//    - entity 정의할 때 기본값 작성
    @NotBlank(message = "사용자 이름은 필수 입력 값입니다.")
    @Length(min = 3, max = 20, message = "사용자 이름은 3자 이상 20자 이하여야 합니다.")
    @Column(unique = true, updatable = false)
    private String username;

    @NotBlank(message = "사용자 이메일은 필수 입력 값입니다.")
    @Email
    private String email;

    @NotBlank(message = "사용자 닉네임은 필수 입력 값입니다.")
    @Length(min = 2, max = 10, message = "사용자 닉네임은 2자 이상 10 이하여야 합니다.")
    private String nickname;

    @Min(value = 0, message = "사용자 나이 0세 이상이여야 합니다.")
    @Max(value = 150, message = "사용자 나이는 150세 이하이여야 합니다.")
    private Integer age;

    public User toEntity() {
        return User.builder()
                .username(this.username)
                .email(this.email)
                .nickname(this.nickname)
                .age(this.age)
                .build();
    }

}
