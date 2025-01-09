package com.example.springprac;

import com.example.springprac.dto.UserCreatedRequestDTO;
import com.example.springprac.dto.UserListResponseDTO;
import com.example.springprac.dto.UserResponseDTO;
import com.example.springprac.dto.UserUpdateRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final  UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(@Valid @RequestBody UserCreatedRequestDTO requestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                      ApiResponse.ok(
                              "새로운 사용자가 생성되었습니다.",
                              "CREATED",
                              userService.createUser(requestDTO)
                      )
                        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserListResponseDTO>>> readUsers() {
        List<UserListResponseDTO> data = userService.readUsers();
        ApiResponse<List<UserListResponseDTO>> response = ApiResponse.ok(data);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> readUserById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(userService.readUserById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> updatePost(@PathVariable Long id,@RequestBody UserUpdateRequestDTO requestDTO) {
        return  ResponseEntity.ok((ApiResponse.ok(userService.updateUser(id, requestDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>>deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "게시글이 정상적으로 삭제되었습니다",
                        "DELETED",
                        null
                )
        );
    }

    @GetMapping("/search/nickname")
    public List<UserListResponseDTO> searchNickname(@RequestParam String nickname) {
        return userService.searchNickname(nickname);
    }

    @GetMapping("/search/age")
    public List<UserListResponseDTO> searchAge(@RequestParam int age) {
        return userService.searchAge(age);
    }

    @GetMapping("/search/active")
    public List<UserListResponseDTO> searchActive(@RequestParam boolean isActive) {
        return userService.searchActive(isActive);
    }

    @GetMapping("/search/email")
    public List<UserListResponseDTO> searchEmail(@RequestParam String email) {
        return userService.searchEmail(email);
    }

    @GetMapping("/search/ageactive")
    public List<UserListResponseDTO> searchAgeActive(@RequestParam int age, @RequestParam boolean isActive) {
        return  userService.searchAgeActive(age,isActive);
    }


}
