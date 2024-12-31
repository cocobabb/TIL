package com.example.demo.myjpasitev3;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryJpaV3 {
    @Persistent
    private final EntityManager em;

    public  PostJpaV3 save(PostJpaV3 postJpaV3) {
        em.persist(postJpaV3);
        return postJpaV3;
    }

    public List<PostJpaV3> findAll(){
        return em.createQuery("SELECT p from POST p", PostJpaV3.class)
                .getResultList();
    }
}