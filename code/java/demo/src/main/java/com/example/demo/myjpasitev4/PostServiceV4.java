package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.myjpasitev4.dto.PostListResponseDto;
import com.example.demo.myjpasitev4.dto.PostResponseDto;
import com.example.demo.myjpasitev4.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
//: 클래스의 모든 메서드가 읽기 전용 트랜잭션으로 실행 됨 => DB 성능 개선(데이터베이스는 잠금이 필요하지 않은 읽기 작업을 수행할 때 리소스를 덜 소모하므로 성능이 향상)
// INSERT, UPDATE, DELETE와 같은 쓰기 작업은 따라 @Transactional 을 이용해 따로 설정해야함
public class PostServiceV4 {

    private final PostRepositoryV4 postRepositoryV4;

    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        PostV4 post = postRepositoryV4.save(requestDto.toEntity());
        return PostResponseDto.from((post));
    }

    public List<PostListResponseDto> readPosts() {
        return postRepositoryV4.findAll()
//        map 메서드를 이용해서 리스트의 각 요소의 값 전체를 처리하기 위해 stream으로 변환하는 과정이 필요(for문도 가능하지만 map 메서드가 편리)
                .stream()
//                .map(x -> PostResponseDto.from(x)); //아래코드와 같이 축약 가능
                .map(PostListResponseDto::from)
                .toList();
    }

    public PostResponseDto readPostById(Long id) {
        PostV4 post = postRepositoryV4.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 게시물입니다."));
        return PostResponseDto.from(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto) {

        PostV4 post = postRepositoryV4.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("업데이트 할 게시물을 찾을 수 없습니다."));
        post.update(requestDto);
        return PostResponseDto.from(post);
    }

    @Transactional
    public void deletePost(Long id) {
        PostV4 post = postRepositoryV4.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제할 게시물을 찾을 수 없습니다."));
        postRepositoryV4.delete(post);

    }
}