package com.hello.java.domain.board.dto;


import com.hello.java.domain.board.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardSaveRequestDto {
    private String title;
    private String content;
    private Long likes;

    private Long views;

    private String tag;

    @Builder
    public BoardSaveRequestDto(String title, String content, String tag) {
        this.title = title;
        this.content = content;
        this.likes = 0L;
        this.views = 0L;
        this.tag = tag;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .likes(likes)
                .views(views)
                .tag(tag)
                .build();
    }
}
