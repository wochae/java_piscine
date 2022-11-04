package com.example.demo.domain.user.dto;

import lombok.Getter;

@Getter
public class UpdateUserReq {
    private Integer id;
    private String name;
    private String email;
    private String password;
}
