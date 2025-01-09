package com.example.springprac;

import com.example.springprac.dto.UserCreatedRequestDTO;
import com.example.springprac.dto.UserListResponseDTO;
import com.example.springprac.dto.UserResponseDTO;
import com.example.springprac.dto.UserUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDTO createUser(UserCreatedRequestDTO requestDTO) {
        String userName = requestDTO.getUsername();
//        if(userName.equals())

        User user = userRepository.save(requestDTO.toEntity());
        return UserResponseDTO.from(user);
    }

    public List<UserListResponseDTO> readUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserListResponseDTO::from)
                .toList();
    }

    public UserResponseDTO readUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->  new RuntimeException());
        return UserResponseDTO.from(user);
    }

    @Transactional
    public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO requestDTO) {
       User user = userRepository.findById(id)
               .orElseThrow( () -> new IllegalArgumentException("업데이트 할 사용자를 찾을 수 없습니다."));
       user.update(requestDTO);
       return UserResponseDTO.from(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제할 사용자를 찾을 수 없습니다."));
        userRepository.delete(user);
    }

    public List<UserListResponseDTO> searchNickname(String nickname) {
        String pattern =  nickname + "%";
        return userRepository.findByNicknameLike(pattern);
    }

    public List<UserListResponseDTO> searchAge(int age) {
        return userRepository.findByAge(age);
    }

    public List<UserListResponseDTO> searchActive(boolean isActive) {
        return userRepository.findByIsActive(isActive);
    }

    public List<UserListResponseDTO> searchEmail(String email) {
        String pattern = "%" + email;
        return userRepository.findByEmailLike(pattern);
    }

    public List<UserListResponseDTO> searchAgeActive(int age, boolean isActive) {
        return userRepository.findByAgeAndIsActive(age, isActive);
    }

}
