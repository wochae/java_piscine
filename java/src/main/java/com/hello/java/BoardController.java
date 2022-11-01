package com.hello.java;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public Board save(@RequestParam("title") String title,
                      @RequestParam("content") String content) {
        Board board = new Board(title, content);
        return boardService.save(board);
    }

    @GetMapping("/board/{boardId}")
    public Board find(@PathVariable("boardId") Long boardId) {
        return boardService.findOne(boardId).orElseThrow();
    }
}
