package com.example.demo.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FindUserRes {
    private String UserName;

    private String email;

    private String password;

    @Builder
    public FindUserRes(String userName, String email, String password) {
        UserName = userName;
        this.email = email;
        this.password = password;
    }
}
