package com.example.demo.domain.board.v1.controller;

import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.v1.dto.BoardAddReqDto;
import com.example.demo.domain.board.v1.dto.BoardFindResDto;
import com.example.demo.domain.board.v1.dto.BoardListDto;
import com.example.demo.domain.board.v1.dto.addTagReqDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BoardController {
    public void saveBoard(@RequestBody Board board);
    public BoardListDto findAllBoardDesc();

    public Board findOneBoard(@RequestParam Integer id);


    public void modifyBoard(@RequestParam String title, @RequestParam String content, @RequestParam Integer id);

    public void destroyBoard(@RequestParam Integer id);

    public void increaseBoardLike(@RequestParam Integer id);

    public void decreaseBoardLike(@RequestParam Integer id);

    public addTagReqDto addTagInBoard(@RequestBody addTagReqDto reqDto);

}
