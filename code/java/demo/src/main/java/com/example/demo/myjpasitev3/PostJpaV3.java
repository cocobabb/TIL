package com.example.demo.myjpasitev3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
//- JPA가 관리하는 객체임을 명시하는 어노테이션이다.
//- 데이터베이스의 테이블과 매핑된다.
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpaV3 {

    @Id
//    기본 키를 매핑하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    기본 키 자동 생성해주는 어노테이션
    private  Long id;

    private  String title;
    private  String content;

    //@NoArgsConstructor(access = AccessLevel.PROTECTED)해서 안해도됨
//    public PostJPA() {
//
//    }

    public PostJpaV3 update(String title, String content) {
        this.title = title;
        this.content = content;

        return this;
    }


}
