package com.example.demo.domain.rike.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
public class RikeRes {
    private Integer rikeId;
    private Integer boardId;
    private Integer userId;

    @Builder
    public RikeRes(Integer rikeId, Integer boardId, Integer userId) {
        this.rikeId = rikeId;
        this.boardId = boardId;
        this.userId = userId;
    }
}
