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
    private Board boardId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    public Rike(Board boardId, User userId) {
        this.boardId = boardId;
        this.userId = userId;
    }
}
