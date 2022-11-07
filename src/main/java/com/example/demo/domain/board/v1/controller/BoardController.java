package com.example.demo.domain.board.v1.controller;

import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.v1.dto.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface BoardController {
    public void saveBoard(@RequestBody BoardAddReqDto req);
    public BoardListDto findAllBoardDesc();

    public Board findOneBoard(@RequestParam Integer id);

    public BoardListDto findBoardsByName(String userName);

    public void deleteBoardBySelf(@RequestBody BoardDeleteBySelfReq req);

    public void modifyBoard(@RequestParam String title, @RequestParam String content, @RequestParam Integer id);

    public void destroyBoard(@RequestParam Integer id);

    public void increaseBoardLike(@RequestParam Integer id);

    public void decreaseBoardLike(@RequestParam Integer id);

    public BoardAddTagReqDto addTagInBoard(@RequestBody BoardAddTagReqDto reqDto);

}
