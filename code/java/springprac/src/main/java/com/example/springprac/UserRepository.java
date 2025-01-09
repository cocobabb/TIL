package com.example.springprac;

import com.example.springprac.dto.UserListResponseDTO;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
    List<UserListResponseDTO> findByNicknameLike(String nickname);
    List<UserListResponseDTO> findByAge(int age);
    List<UserListResponseDTO> findByIsActive(boolean isActive);
    List<UserListResponseDTO> findByEmailLike(String email);
    List<UserListResponseDTO> findByAgeAndIsActive(int age, boolean isActive);

}
