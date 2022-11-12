package com.example.demo.domain.rike;


import com.example.demo.domain.BaseTimeEntity;
import com.example.demo.domain.board.Board;
import com.example.demo.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Rike extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Rike(Board board, User user) {
        this.board = board;
        this.user = user;
    }
}

