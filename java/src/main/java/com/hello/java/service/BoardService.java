package com.hello.java.service;

import com.hello.java.domain.board.Board;
import com.hello.java.domain.board.BoardRepository;
import com.hello.java.web.dto.BoardListResponseDto;
import com.hello.java.web.dto.BoardSaveRequestDto;
import com.hello.java.web.dto.BoardUpdateRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board save(BoardSaveRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity());
    }

    @Transactional
    public Long updateBoard(Long id, BoardUpdateRequestDto boardUpdateRequestDto) {
        Board board = findOne(id).orElseThrow();
        board.update(boardUpdateRequestDto);
        return id;
    }

    @Transactional(readOnly = true)
    public Optional<Board> findOne(Long boardId) {
        return boardRepository.findById(boardId);
    }

    @Transactional(readOnly = true)
    public BoardListResponseDto findBoards() {

        List<Board> boards = boardRepository.findAll();
        BoardListResponseDto boardBoardListResponseDto = BoardListResponseDto.builder()
                .boards(boards)
                .total(boards.size())
                .build();
        return boardBoardListResponseDto;
    }

    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow();
        boardRepository.delete(board);
    }

    @Transactional
    public void updateLikes(Long id, Boolean isLike) {
        Board findBoard = findOne(id).orElseThrow();
        findBoard.updateLike(isLike);
    }

    @Transactional
    public void updateViews(Long id) {
        Board findBoard = findOne(id).orElseThrow();
        findBoard.updateViews();
    }
}
