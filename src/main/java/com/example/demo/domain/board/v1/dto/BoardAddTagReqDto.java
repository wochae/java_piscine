package com.example.demo.domain.board.v1.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardAddTagReqDto {
    private Integer boardId;
    private String tag;

    @Builder
    public BoardAddTagReqDto(Integer boardId, String tag) {
        this.boardId = boardId;
        this.tag = tag;
    }
}
