package com.example.demo.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UpdateUserRes {
    private String name;
    @Setter
    private String email;

    @Builder
    public UpdateUserRes(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
