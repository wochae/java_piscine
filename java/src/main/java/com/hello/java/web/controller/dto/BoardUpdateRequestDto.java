package com.hello.java.domain.board.dto;

import com.hello.java.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {

    private String title;
    private String content;
    private String tag;

    @Builder
    public BoardUpdateRequestDto(String title, String content, String tag) {
        this.title = title;
        this.content = content;
        this.tag = tag;
    }
    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .tag(tag)
                .build();
    }

}
