package com.example.demo.domain.board.v1.controller;

import com.example.demo.domain.board.Board;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BoardController {
    public void saveBoard(@RequestBody Board board);
    List<Board> findAllBoardDesc();

    Board findOneBoard(@RequestParam Integer id);

    public void modifyBoard(@RequestParam String title, @RequestParam String content, @RequestParam Integer id);

    public void destroyBoard(@RequestParam Integer id);
}
