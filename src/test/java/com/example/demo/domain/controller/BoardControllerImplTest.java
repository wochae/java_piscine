package com.example.demo.domain.controller;

import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.BoardRepository;
import com.example.demo.domain.board.BoardService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardControllerImplTest {

    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;



    @Test
    void saveBoard() {
    }

    @Test
    void findAllBoardDesc() {
    }

    @Test
    void findOneBoard() {
        // given
        Board board = new Board();

        // when
        Integer id = boardRepository.save(board).getId();
        Board origin1 = boardService.findById(id);
        int beforeView = origin1.getView();
        boardService.viewBoard(id);

        // 왜 origin 으로 따로 값을 넣어줘야 비교할 수 있나
        // then
        Board origin2 = boardService.findById(id);
        int afterView = origin2.getView();
        Assertions.assertThat(afterView).isEqualTo(beforeView + 1);
    }

    @Test
    void modifyBoard() {
    }
}