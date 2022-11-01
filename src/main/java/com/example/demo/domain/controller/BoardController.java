package com.example.demo.domain.controller;

import com.example.demo.domain.Board;
import com.example.demo.domain.dto.BoardAddReqDto;
import com.example.demo.domain.dto.BoardFindResDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface BoardController {
    void saveBoard(@RequestBody BoardAddReqDto addDto);
    List<Board> findAllBoardDesc();

    BoardFindResDto findOneBoard(@RequestParam Integer id);


}
