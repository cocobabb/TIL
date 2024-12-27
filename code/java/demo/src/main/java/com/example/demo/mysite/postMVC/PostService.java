package com.example.demo.mysite.postMVC;

import com.example.demo.mysite.Post;

import java.util.List;

public class PostService {
    PostRepository postRepository = new PostRepository();

    public Post createPost(Post newPost) {
//        String  title = newPost.getTitle();
//        String content = newPost.getContent();
//
//        if(title == null || title.isBlank()){
//            throw new RuntimeException("title을 입력해주세요");
//        }
//
//        if(content == null || content.isBlank()){
//            throw new IllegalArgumentException("content를 입력하시오");
//        }
        validatePostData(newPost);

//      post 생성
        return postRepository.save(newPost);
    }


    public List<Post> readPosts(){
        return postRepository.findAll();
    }


    public Post readPostById(Long id) {
        Post post = postRepository.findById(id);

//        if(post == null) {
//            throw new IllegalArgumentException("없는 id입니다");
//        }

        checkPostIsNull(post);
        return post;
    }

    public Post updatePost(Long id, Post updatePost) {
        Post post = postRepository.findById(id);
//        if (post == null) {
//              throw new IllegalArgumentException("없는 id입니다");
//        }
        checkPostIsNull(post);
        return post;
    }


    public void deletePost(Long id) {
        Post post = postRepository.findById(id);
        checkPostIsNull(post);

        postRepository.delete(post);
    }

    public void checkPostIsNull(Post post) {
        if(post == null) {
            throw new IllegalArgumentException("없는 id입니다");
        }
    }

    public void validatePostData(Post post) {
        String title = post.getTitle();
        String content = post.getContent();

        if(title == null || title.isBlank()){
            throw new RuntimeException("title을 입력해주세요");
        }
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("content를 입력해주세요");
        }

    }
}
