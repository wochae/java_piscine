package com.example.demo.domain.board;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;

    @Test
    void addBoard() {

        // given
        Board board = new Board();
        board.setTitle("123");
        board.setContent("123");

        // when
        Integer id = boardRepository.save(board).getId();

        // then
        Board findBoard = boardService.findById(id);
        assertThat(board.getTitle()).isEqualTo(findBoard.getTitle());
        assertThat(board.getContent()).isEqualTo(findBoard.getContent());
    }

    @Test
    void findById() {
    }

    @Test
    void findBoards() {
    }

    @Test
    void modifyBoard() {
    }

    @Test
    void destroyBoard() {
    }
}