package com.hello.java;

import com.hello.java.domain.board.Board;
import com.hello.java.domain.board.controller.BoardController;
import com.hello.java.domain.board.dto.BoardListResponseDto;
import com.hello.java.domain.board.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
class BoardControllerTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardController boardController;

    @Test
    public void findBoard() {

        //given
        Board board1 = Board.builder().title("hello").content("world").build();
        Board board2 = Board.builder().title("Yello").content("work").build();
        Board board3 = Board.builder().title("42gg").content("world").build();

        //when
        boardRepository.save(board1);
        boardRepository.save(board2);
        boardRepository.save(board3);

        //then
        BoardListResponseDto findBoardsDto = boardController.findBoards();
        List<Board> boards = boardRepository.findAll();

        Assertions.assertThat(findBoardsDto.getTotal()).isEqualTo(boards.size());
        Assertions.assertThat(findBoardsDto.getBoardList().get(1)).isEqualTo(boards.get(1));
    }

}