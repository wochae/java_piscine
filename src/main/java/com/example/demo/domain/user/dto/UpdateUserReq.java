package com.example.demo.domain.user.dto;

import lombok.Getter;

@Getter
public class UpdateUserReq {
    private Integer id;
    private String name;
    private String email;
    private String password;

    public UpdateUserReq(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
