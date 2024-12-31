package com.example.demo.myjpasitev2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceJpaV2 {

    private final PostRepositoryJpaV2 postRepositoryJpaV2;

//    @RequiredArgsConstructor를 써서 생성자 필요 없음(자동으로 생성해줌)
//    public PostServiceJpaV2(PostReopositoryJpaV2 postReopositoryJpaV2) {
//        this.postReopositoryJpaV2 = postReopositoryJpaV2;
//    }

    public PostJpaV2 createPost(PostJpaV2 postJpa) {
        return postRepositoryJpaV2.save(postJpa);
    }


    public List<PostJpaV2> readPost() {
        return postRepositoryJpaV2.findAll();
    }

    public PostJpaV2 readPostById(Long id) {
        return postRepositoryJpaV2.findById(id);
    }

    public PostJpaV2 updatePost(Long id, PostJpaV2 updatePostJpa) {
        return postRepositoryJpaV2.update(id,updatePostJpa);

//        위와 같은 코드
//        postReopositoryJpa.save(postJpa.update(title, content));
//    }
    }

    public void deletePost(Long id) {
        postRepositoryJpaV2.delete(id);
    }
}