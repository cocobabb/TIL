package com.example.demo.myjpasitev3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
//: 클래스의 모든 메서드가 읽기 전용 트랜잭션으로 실행 됨 => DB 성능 개선(데이터베이스는 잠금이 필요하지 않은 읽기 작업을 수행할 때 리소스를 덜 소모하므로 성능이 향상)
// INSERT, UPDATE, DELETE와 같은 쓰기 작업은 따라 @Transactional 을 이용해 따로 설정해야함
public class PostServiceJpaV3 {

    private final PostRepositoryJpaV3 postRepositoryJpaV3;

    @Transactional
    public  PostJpaV3 createPost(PostJpaV3 post) {
        return postRepositoryJpaV3.save(post);
    }

//    read 관련은 클래스에다가 어노테이션을 설정해서 위에 코드와 같이 @Transactional을 넣을 필요가 없음
    public List<PostJpaV3> readPost() {
        return postRepositoryJpaV3.findAll();
    }
}