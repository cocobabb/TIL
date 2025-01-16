package com.example.relation.domain.user.controller;

import com.example.relation.domain.user.dto.response.Post2ListWithPageResponseDto;
import com.example.relation.domain.user.dto.response.UserResponseDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.domain.user.service.UserService;
import com.example.relation.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/my/profile")
    public ResponseEntity<ApiResponse<UserResponseDto>> getMyProfile() {
//        @AuthenticationPrincipal 로 대체 가능
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(
                ApiResponse.ok(
                        userService.getMyProfile(user)
                )
        );
    }

    @GetMapping("/my/profile2")
    public ResponseEntity<ApiResponse<UserResponseDto>> getMyProfile2(
            @AuthenticationPrincipal User user
    ){
        return ResponseEntity.ok(ApiResponse.ok(
                userService.getMyProfile(user)
        ));
    }

    @GetMapping("/my/posts")
//    *나의* 게시물을 가져올 것이니까 인증을 저장한 @AuThenticationPrincipal 이 필요하고 게시물이 여러개일테니까 pagination(=> pageable)이 필요할 것
    public ResponseEntity<ApiResponse<Post2ListWithPageResponseDto>> getMyPosts(@AuthenticationPrincipal User user, Pageable pageable) {
         return ResponseEntity.ok(
                 ApiResponse.ok(
                         userService.getMyPosts(user, pageable)
                 )
         );
    }

}
