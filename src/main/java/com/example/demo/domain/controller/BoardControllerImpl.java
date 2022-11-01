package com.example.demo.domain.controller;


import com.example.demo.domain.Board;
import com.example.demo.domain.BoardService;
import com.example.demo.domain.dto.BoardAddReqDto;
import com.example.demo.domain.dto.BoardFindResDto;
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
    public void saveBoard(BoardAddReqDto addDto) {
        boardService.addBoard(addDto);
    }

    @Override
    @GetMapping(value = "/post")
    public List<Board> findAllBoardDesc() {

        List<Board> dtos = boardService.findBoards();

        return dtos;
    }

    @Override
    public BoardFindResDto findOneBoard(Integer id) {
        return boardService.findBoard(id);
    }


}
