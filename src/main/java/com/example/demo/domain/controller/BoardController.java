package com.example.demo.domain.controller;

import com.example.demo.domain.Board;
import com.example.demo.domain.dto.BoardAddReqDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BoardController {
    void saveBoard(@RequestBody BoardAddReqDto addDto);
    List<Board> findAllBoardDesc();
}
