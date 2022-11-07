package com.example.demo.domain.board.v1.dto;

import com.example.demo.domain.board.Board;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class BoardListDto {
    List<Board> BoardList;
    int countBoard;



}

