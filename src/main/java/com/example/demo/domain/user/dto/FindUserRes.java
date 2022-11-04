package com.example.demo.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FindUserRes {
    private String UserName;
    private String email;

    @Builder
    public FindUserRes(String userName, String email) {
        UserName = userName;
        this.email = email;
    }
}
