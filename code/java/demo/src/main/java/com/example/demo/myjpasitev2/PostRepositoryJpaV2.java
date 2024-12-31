package com.example.demo.myjpasitev2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryJpaV2 {
    @PersistenceUnit
    private final EntityManagerFactory emf;

    public PostJpaV2 save(PostJpaV2 postJps2) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(postJps2); //저장

            tx.commit();
            return postJps2;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public PostJpaV2 findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
//            클래스 자체가 아니라 클래스의 메타데이터가 필요함
            return em.find(PostJpaV2.class, id);
        }finally {
            em.close();
        }
    }

    public List<PostJpaV2> findAll() {
        EntityManager em = emf.createEntityManager();
//        post에서 모든 데이터를 가져오고 싶음 => SELECT * FROM posts p
//        JPQL => 테이블을 엔티티로 만듦
        try{
//            createQuery 함수는 sql문, 베이스 테이블의 class 메타데이터를 필요로 함
//            .class 메타데이터 가져오는 것
            return em.createQuery("SELECT p FROM postJapV2 p", PostJpaV2.class)
                    .getResultList();
        }finally {
            em.close();
        }

    }
    public PostJpaV2 update(Long id, PostJpaV2 updatedPost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            PostJpaV2 post = em.find(PostJpaV2.class, id);

            String updatedTitle = updatedPost.getTitle();
            String updatedContent = updatedPost.getContent();

            post.update(updatedTitle, updatedContent);

            tx.commit();
            return post;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void  delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            PostJpaV2 post = em.find(PostJpaV2.class, id);
            em.remove(post);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

}


