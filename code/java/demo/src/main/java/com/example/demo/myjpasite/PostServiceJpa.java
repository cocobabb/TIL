package com.example.demo.myjpasite;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceJpa {
    private final PostReopositoryJpa postReopositoryJpa;

    public PostServiceJpa(PostReopositoryJpa postReopositoryJpa) {
        this.postReopositoryJpa = postReopositoryJpa;
    }

    public PostJpa createPost(PostJpa postJpa) {
        return postReopositoryJpa.save(postJpa);
    }

    public List<PostJpa> readPost() {
        return postReopositoryJpa.findAll();
    }

    public PostJpa readPostById(Long id) {
        return postReopositoryJpa.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 Post입니다"));
    }

    public PostJpa updatePost(Long id, PostJpa updatePostJpa) {
        PostJpa postJpa = postReopositoryJpa.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 Post입니다"));
        String title = updatePostJpa.getTitle();
        String content = updatePostJpa.getContent();

        postJpa.update(title, content);
        return postReopositoryJpa.save(postJpa);

//        위와 같은 코드
//        postReopositoryJpa.save(postJpa.update(title, content));
    }
}
