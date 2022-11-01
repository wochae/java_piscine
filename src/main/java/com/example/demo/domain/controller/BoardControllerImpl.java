package com.example.demo.domain.controller;


import com.example.demo.domain.Board;
import com.example.demo.domain.BoardService;
import com.example.demo.domain.dto.BoardAddReqDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/board")
public class BoardControllerImpl implements BoardController{

    private final BoardService boardService;



    @Override
    @PostMapping(value = "/post")
    public void saveBoard(BoardAddReqDto addDto) {
        boardService.addBoard(addDto);
    }

    @Override
    @GetMapping(value = "/post")
    public List<Board> findAllBoardDesc() {

        List<Board> dtos = boardService.findBoards();

        return dtos;
    }
}
