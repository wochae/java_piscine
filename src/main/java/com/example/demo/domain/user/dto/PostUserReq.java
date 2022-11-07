package com.example.demo.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class PostUserReq {
    private String userName;
    private String email;
    private String password;
}
