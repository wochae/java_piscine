package com.hello.java;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public Board saveBaord(@RequestParam("title") String title,
                      @RequestParam("content") String content) {
        Board board = new Board(title, content);
        return boardService.save(board);
    }

    @GetMapping("/board/{boardId}")
    public Board findBoard(@PathVariable("boardId") Long boardId) {
        return boardService.findOne(boardId).orElseThrow();
    }

    @GetMapping("/board")
    public List<Board> findBoards() {
        return boardService.findBoards();
    }

    @PutMapping("/board/{boardId}")
    public Long updateBoard(@PathVariable("boardId") Long boardId, @RequestBody BoardUpdateDto boardUpdateDto) {
        return boardService.update(boardId, boardUpdateDto);
    }

}
