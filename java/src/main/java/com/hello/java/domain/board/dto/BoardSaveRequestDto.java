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

    @Builder
    public BoardSaveRequestDto(String title, String content, Long likes, Long views) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.views = views;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .likes(likes)
                .views(views)
                .build();
    }
}
