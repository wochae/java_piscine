package com.example.demo.domain.board.v1.dto;

import lombok.Getter;

@Getter
public class BoardDeleteBySelfReq {
    private String email;
    private String password;
    private Integer boardId;
}
