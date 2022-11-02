package com.example.demo.domain.board.v1.dto;

import lombok.Getter;

@Getter
public class BoardModifyReqDto {
    private Integer id;
    private String title;
    private String content;
}
