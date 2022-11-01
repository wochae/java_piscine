package com.hello.java;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board save(Board board) {

        Board newBoard = new Board(board.getTitle(), board.getContent());
        return boardRepository.save(newBoard);
    }
}
