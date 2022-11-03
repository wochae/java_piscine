package com.hello.java.domain.board.controller;


import com.hello.java.domain.board.Board;
import com.hello.java.domain.board.BoardService;
import com.hello.java.domain.board.dto.BoardSaveRequestDto;
import com.hello.java.domain.board.dto.BoardUpdateDto;
import com.hello.java.domain.board.dto.BoardListResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public Board saveBaord(@RequestBody BoardSaveRequestDto requestDto) {
        return boardService.save(requestDto);
    }

    @GetMapping("/board/{boardId}")
    public Board findBoard(@PathVariable("boardId") Long boardId) {
        return boardService.findOne(boardId).orElseThrow();
    }

    @GetMapping("/board")
    public BoardListResponseDto findBoards() {
        return boardService.findBoards();
    }

    @PutMapping("/board/{boardId}")
    public Long updateBoard(@PathVariable("boardId") Long boardId, @RequestBody BoardUpdateDto boardUpdateDto) {
        return boardService.updateBoard(boardId, boardUpdateDto);
    }

    @DeleteMapping("/board")
    public void deleteBoard(@RequestParam Long boardId) {
        boardService.delete(boardId);
    }

    @PutMapping("/board/like/{boardId}")
    public void updateLikes(@PathVariable("boardId") Long boardId, @RequestParam Long likes) {
        boardService.updateLike(boardId, likes);
    }
}
