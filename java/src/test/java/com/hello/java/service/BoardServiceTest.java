package com.hello.java.service;

import com.hello.java.domain.board.Board;
import com.hello.java.domain.board.BoardRepository;
import com.hello.java.web.dto.BoardSaveRequestDto;
import com.hello.java.web.dto.BoardUpdateRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardService boardService;
    @Test
    public void 게시글이_저장된다() {

        // given
        String title = "42gg";
        String content = "salee";
        String tag = "#42gg";

        boardRepository.save(BoardSaveRequestDto.builder()
                .title(title)
                .content(content)
                .tag(tag)
                .build()
                .toEntity());

        // when
        List<Board> findBoards = boardRepository.findAll();

        //then
        Board findBoard = findBoards.get(0);
        assertThat(findBoard.getTitle()).isEqualTo(title);
        assertThat(findBoard.getContent()).isEqualTo(content);
        assertThat(findBoard.getLikes()).isEqualTo(0L);
        assertThat(findBoard.getTag()).isEqualTo(tag);
    }

    @Test
    public void 게시글이_수정되다() {

        // given
        Board board = BoardSaveRequestDto.builder()
                .title("42gg")
                .content("salee2")
                .tag("#42gg")
                .build()
                .toEntity();

        boardRepository.save(board);

        // when
        List<Board> findBoards = boardRepository.findAll();

        String title = "42seoul";
        String content = "cadet";
        String tag = "#pipex";

        Board updateBoard = BoardUpdateRequestDto.builder()
                .title(title)
                .content(content)
                .tag(tag)
                .build()
                .toEntity();
        boardService.update(findBoards.get(0).getId(), updateBoard);

        //then
        Board findBoard = findBoards.get(0);
        assertThat(findBoard.getTitle()).isEqualTo(title);
        assertThat(findBoard.getContent()).isEqualTo(content);
        assertThat(findBoard.getLikes()).isEqualTo(0);
        assertThat(findBoard.getViews()).isEqualTo(0);
        assertThat(findBoard.getTag()).isEqualTo(tag);
    }

    @Test
    public void 좋아요가_변경된다() {

        String title = "42gg";
        String content = "salee";

        boardRepository.save(BoardSaveRequestDto.builder()
                .title(title)
                .content(content)
                .build()
                .toEntity());

        // when
        List<Board> findBoards = boardRepository.findAll();

        //then
        Long deltaLikes1 = 10L;
        Board findBoard = findBoards.get(0);

        boardService.updateLikes(findBoard.getId(), Boolean.TRUE);
        assertThat(findBoard.getLikes()).isEqualTo(1);
        boardService.updateLikes(findBoard.getId(), Boolean.FALSE);
        assertThat(findBoard.getLikes()).isEqualTo(0);
    }

    @Test
    public void 조회수가_올라간다() {

        String title = "42gg";
        String content = "salee";

        boardRepository.save(BoardSaveRequestDto.builder()
                .title(title)
                .content(content)
                .build()
                .toEntity());

        // when
        List<Board> findBoards = boardRepository.findAll();

        //then
        Board findBoard = findBoards.get(0);

        assertThat(findBoard.getViews()).isEqualTo(0);
        for (int i = 0; i < 42; ++i) {
            findBoard.updateViews();
        }
        assertThat(findBoard.getViews()).isEqualTo(42);
    }
}