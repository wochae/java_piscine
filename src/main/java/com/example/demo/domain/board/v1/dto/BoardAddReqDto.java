package com.example.demo.domain.board.v1.dto;


import com.example.demo.domain.user.User;
import lombok.Getter;

@Getter
public class BoardAddReqDto {
    private String title;
    private String content;
    private Integer userId;
}
