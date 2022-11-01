package com.example.demo.domain.dto;


import com.example.demo.domain.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardFindResDto {
    private Integer id;
    private String title;
    private String content;

    public BoardFindResDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}


