package com.hello.java.web.dto;

import com.hello.java.domain.board.Board;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BoardListResponseDto{

    private List<Board> boardList;
    private int total;

    public BoardListResponseDto() {
        this.boardList = new ArrayList<Board>();
    }

    @Builder
    public BoardListResponseDto(List<Board> boards, int total) {
        this.boardList = boards;
        this.total = total;
    }
}
