package com.example.demo.domain.board.v1.dto;

import lombok.Builder;

import java.util.List;

@Builder
public class BoardListDto {
    List<BoardFindResDto> BoardList;
    // 얘는 그럼 언제 쓰냐?


}

