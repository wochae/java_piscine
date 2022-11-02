package com.example.demo.domain.board;

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
    public void addBoard(Board board) {
        Board b = Board.builder()
                        .title(board.getTitle())
                        .content(board.getContent())
                        .build();
        boardRepository.save(b);
    }

    @Transactional
    public Board findById(Integer id) {
        Board board = boardRepository.findById(id)
                .orElse(null);

        return board;
    }

    @Transactional
    public List<Board> findBoards() {
        return boardRepository.findAllDesc();
    }


    @Transactional
    public void modifyBoard(String title, String content, Integer id) {
        Optional<Board> board = boardRepository.findById(id);
        Board newBoard = board.get();
        newBoard.setTitle(title);
        newBoard.setContent(content);

    }
    @Transactional
    public void destroyBoard(Integer id) {
        Board board = findById(id);
        boardRepository.delete(board);
    }
    @Transactional
    public void viewBoard(Integer id) {
        Board findBoard = findById(id);
        findBoard.setView(findBoard.getView() + 1);
    }
}
