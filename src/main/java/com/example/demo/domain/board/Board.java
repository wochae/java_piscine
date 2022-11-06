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
    private User user_id;
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
    public Board(Integer id, String title, String content, User user_id, Integer view, Integer like, String tag) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.view = view;
        this.like = like;
        this.tag = tag;
    }
}

