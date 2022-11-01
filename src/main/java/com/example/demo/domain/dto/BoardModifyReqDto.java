package com.example.demo.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class BoardModifyReqDto {
    private Integer id;
    private String title;
    private String content;
}
