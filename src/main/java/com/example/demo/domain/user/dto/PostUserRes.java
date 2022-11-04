package com.example.demo.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUserRes {
    private String email;
    private Integer id;

    @Builder
    public PostUserRes(String email, Integer id) {
        this.email = email;
        this.id = id;
    }
}
