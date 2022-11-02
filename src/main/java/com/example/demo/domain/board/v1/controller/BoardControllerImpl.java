package com.example.demo.domain.board.v1.controller;


import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/board/v1")
public class BoardControllerImpl implements BoardController {

    private final BoardService boardService;


    @Override
    @PostMapping(value = "/post")
    public void saveBoard(Board board) {
        boardService.addBoard(board);
    }


    @Override
    @GetMapping(value = "/post")
    public List<Board> findAllBoardDesc() {

        List<Board> dtos = boardService.findBoards();

        return dtos;
    }

    @Override
    @GetMapping(value = "/post/")
    public Board findOneBoard(Integer id) {

        return boardService.findById(id);
    }


    @Override
    @PutMapping(value = "/post")
    public void modifyBoard(String title, String content, Integer id) {
        boardService.modifyBoard(title, content, id);

    }

    @Override
    @DeleteMapping(value = "/post")
    public void destroyBoard(Integer id) {
        boardService.destroyBoard(id);
    }


}
