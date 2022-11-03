package com.hello.java.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
//    private Long like;

    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
//        this.like = like;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

//    public void updateLike(Long likeOffset) {
//        this.like += likeOffset;
//    }

}
