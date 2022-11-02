package com.example.demo.domain.board.v1.dto;


import com.example.demo.domain.board.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardFindResDto {
    private Integer id;
    private String title;
    private String content;
    private Integer view;
}


