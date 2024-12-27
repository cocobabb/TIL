package com.example.demo.mysite.postMVC;

import com.example.demo.mysite.Post;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    //    여러 게시글을 가지고 있을 리스트 생성
    List<Post> posts = new ArrayList<>();
    //    게시글 생성에서 id 생성을 위한 장치
    private Long id = 0L;

    public Post save(Post newPost) {
        Post post = new Post(++id, newPost.getTitle(), newPost.getContent());
        posts.add(post);
        return post;
    }

    public  List<Post> findAll(){
        return posts;
    }

    public Post findById(Long id) {
        for(Post post : posts) {
            if(post.getId().equals(id)){
                return post;
            }
        }
        return null;
    }

    public Post modify(Long id, Post updatedPost) {
        String newTitle = updatedPost.getTitle();
        String newContent = updatedPost.getContent();

        for (Post post : posts) {
            if(post.getId().equals(id)){
                post.setTitle(newTitle);
                post.setTitle(newContent);
                return post;
            }
        }
        return null;
    }

    public void delete(Post post) {
        posts.remove(post);
    }

}
