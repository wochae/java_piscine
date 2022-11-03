package com.hello.java.domain.board;

import com.hello.java.domain.board.dto.BoardSaveRequestDto;
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
        Long likes = 100L;

        boardRepository.save(BoardSaveRequestDto.builder()
                .title(title)
                .content(content)
                .likes(likes)
                .build()
                .toEntity());

        // when
        List<Board> findBoards = boardRepository.findAll();

        //then
        Board findBoard = findBoards.get(0);
        assertThat(findBoard.getTitle()).isEqualTo(title);
        assertThat(findBoard.getContent()).isEqualTo(content);
        assertThat(findBoard.getLikes()).isEqualTo(likes);
    }

    @Test
    public void 좋아요가_변경된다() {

        String title = "42gg";
        String content = "salee";
        Long likes = 100L;

        boardRepository.save(BoardSaveRequestDto.builder()
                .title(title)
                .content(content)
                .likes(likes)
                .build()
                .toEntity());

        // when
        List<Board> findBoards = boardRepository.findAll();

        //then
        Long deltaLikes1 = 10L;
        Board findBoard = findBoards.get(0);
        findBoard.updateLike(deltaLikes1);
        assertThat(findBoard.getLikes()).isEqualTo(likes + deltaLikes1);
        findBoard.updateLike(-deltaLikes1);
        assertThat(findBoard.getLikes()).isEqualTo(likes);
    }
}