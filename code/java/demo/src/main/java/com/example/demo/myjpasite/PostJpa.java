package com.example.demo.myjpasite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String title;
    private  String content;

    //@NoArgsConstructor(access = AccessLevel.PROTECTED)해서 안해도됨
//    public PostJPA() {
//
//    }

    public PostJpa update(String title, String content) {
        this.title = title;
        this.content = content;

        return this;
    }


}
