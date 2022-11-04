package com.hello.java.domain.board;

import com.hello.java.domain.BaseTimeEntity;
import com.hello.java.web.controller.dto.BoardUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long likes;
    private Long views;
    private String tag;

    @Builder
    public Board(String title, String content, Long likes, Long views, String tag) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.views = views;
        this.tag = tag;
    }
    public void update(BoardUpdateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.tag = requestDto.getTag();
    }

    public void updateLike(Boolean isLike) {
        if (isLike) {
            ++this.likes;
        } else {
            --this.likes;
        }
    }

    public void updateViews() {
        ++this.views;
    }

}
