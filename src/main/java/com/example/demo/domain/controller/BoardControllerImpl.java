package com.example.demo.domain.controller;


import com.example.demo.domain.Board;
import com.example.demo.domain.BoardService;
import com.example.demo.domain.dto.BoardAddReqDto;
import com.example.demo.domain.dto.BoardModifyReqDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/board")
public class BoardControllerImpl implements BoardController{

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
