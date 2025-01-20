package com.example.relation.domain.user.controller;

import com.example.relation.domain.user.dto.request.LoginRequestDto;
import com.example.relation.domain.user.dto.request.SignupRequestDto;
import com.example.relation.domain.user.dto.response.SignupResponseDto;
import com.example.relation.domain.user.dto.response.TokenResponseDto;
import com.example.relation.domain.user.service.AuthService;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor //service를 DI 해주기 위한 생성자
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public  ResponseEntity<ApiResponse<SignupResponseDto>> signup(@Valid @RequestBody SignupRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok(
                        authService.signup(requestDto)
                ));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponseDto>> login(@Valid @RequestBody LoginRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        authService.login(requestDto)
                )
        );
    }

    @GetMapping("/verify")
    public void verify(){}

}
