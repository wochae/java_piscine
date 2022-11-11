package com.example.demo.domain.board.v1.controller;

import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.v1.dto.*;
import com.example.demo.domain.rike.dto.RikeReq;
import com.example.demo.domain.rike.dto.RikeRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface BoardController {
    public void saveBoard(@RequestBody BoardAddReqDto req);
    public BoardListDto findAllBoardDesc();

    public Board findOneBoard(@RequestParam Integer id);

    public BoardListDto findBoardsByName(@PathVariable String userName);

    public Page<Board> findBoardPageByUserName(@PathVariable String userName, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable);

    public void deleteBoardBySelf(@RequestBody BoardDeleteBySelfReq req);

    public void modifyBoard(@RequestParam String title, @RequestParam String content, @RequestParam Integer id);

    public void destroyBoard(@RequestParam Integer id);

    public void increaseBoardLike(@RequestBody RikeReq req);

    public void decreaseBoardLike(@RequestBody RikeReq req);

    public BoardAddTagReqDto addTagInBoard(@RequestBody BoardAddTagReqDto reqDto);

}
