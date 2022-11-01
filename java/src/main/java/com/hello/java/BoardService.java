package com.hello.java;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board save(Board board) {
        Board newBoard = new Board(board.getTitle(), board.getContent());
        return boardRepository.save(newBoard);
    }

    public Optional<Board> findOne(Long boardId) {
        return boardRepository.findById(boardId);
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }


}
