package com.example.demo.domain.board;

import com.example.demo.domain.BaseTimeEntity;
import com.example.demo.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    @Column(name = "title")
    private String title;
    @Setter
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Setter
    @Column
    private Integer view;

    @Setter
    @Column(name = "countRike")
    private Integer like;

    @Setter
    @Column(name = "tag")
    private String tag;

    @Builder
    public Board(String title, String content, User user, Integer view, Integer like) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.view = 0;
        this.like = 0;
    }
}

