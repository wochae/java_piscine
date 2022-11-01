package com.example.demo.domain.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardFindResDto {
    private Integer id;
    private String title;
    private String content;
}
