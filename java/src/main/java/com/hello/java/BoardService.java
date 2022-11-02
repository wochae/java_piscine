package com.hello.java;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Transactional
    public Long update(Long id, BoardUpdateDto boardUpdateDto) {
        Board board = findOne(id).orElseThrow();
        board.update(boardUpdateDto.getTitle(), boardUpdateDto.getContent());
        return id;
    }

    public Optional<Board> findOne(Long boardId) {
        return boardRepository.findById(boardId);
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow();
        boardRepository.delete(board);
    }
}
