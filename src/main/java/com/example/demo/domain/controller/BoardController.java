package com.example.demo.domain.controller;

import com.example.demo.domain.Board;
import com.example.demo.domain.dto.BoardAddReqDto;
import com.example.demo.domain.dto.BoardFindResDto;
import com.example.demo.domain.dto.BoardModifyReqDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface BoardController {
    public void saveBoard(@RequestBody Board board);
    List<Board> findAllBoardDesc();

    Board findOneBoard(@RequestParam Integer id);

    public void modifyBoard(@RequestParam String title, @RequestParam String content, @RequestParam Integer id);

    public void destroyBoard(@RequestParam Integer id);
}
