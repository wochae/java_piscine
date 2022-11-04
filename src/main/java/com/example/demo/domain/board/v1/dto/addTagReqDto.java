package com.example.demo.domain.board.v1.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class addTagReqDto {
    private Integer boardId;
    private String tag;

    @Builder
    public addTagReqDto(Integer boardId, String tag) {
        this.boardId = boardId;
        this.tag = tag;
    }
}
