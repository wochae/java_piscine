package com.example.demo.domain.board.v1.controller;

import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.v1.dto.BoardListDto;
import com.example.demo.domain.board.v1.dto.BoardFindResDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BoardController {
    public void saveBoard(@RequestBody Board board);
    List<BoardFindResDto> findAllBoardDesc();

    public int CountBoardList();

    BoardFindResDto findOneBoard(@RequestParam Integer id);

    public void modifyBoard(@RequestParam String title, @RequestParam String content, @RequestParam Integer id);

    public void destroyBoard(@RequestParam Integer id);


}
