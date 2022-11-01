package com.example.demo.domain.controller;

import com.example.demo.domain.Board;
import com.example.demo.domain.dto.BoardAddReqDto;
import com.example.demo.domain.dto.BoardFindResDto;
import com.example.demo.domain.dto.BoardModifyReqDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BoardController {
    public void saveBoard(@RequestBody BoardAddReqDto addDto);
    List<Board> findAllBoardDesc();

    BoardFindResDto findOneBoard(@RequestParam Integer id);

    public void modifyBoard(@RequestBody BoardModifyReqDto modifyDto);
}
