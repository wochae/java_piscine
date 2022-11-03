package com.hello.java.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    private Long likes;

    @Builder
    public Board(String title, String content, Long likes) {
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updateLike(Long likesOffset) {
        this.likes += likesOffset;
    }

}
