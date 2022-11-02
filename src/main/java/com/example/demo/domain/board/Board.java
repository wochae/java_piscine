package com.example.demo.domain.board;

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

    @Builder
    public Board(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
