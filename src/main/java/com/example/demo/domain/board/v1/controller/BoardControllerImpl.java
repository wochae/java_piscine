package com.example.demo.domain.board.v1.controller;


import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.BoardService;
import com.example.demo.domain.board.v1.dto.BoardFindResDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/board")
public class BoardControllerImpl implements BoardController {

    private final BoardService boardService;


    @Override
    @PostMapping(value = "/post")
    public void saveBoard(Board board) {
        boardService.addBoard(board);
    }


    @Override
    @GetMapping(value = "/post")
    public List<BoardFindResDto> findAllBoardDesc() {
        List<Board> boards = boardService.findBoards();


        List<BoardFindResDto> boardList = new ArrayList<>();
        for (Board board : boards) {
            boardList.add(BoardFindResDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent()).build()
            );
        }

        return boardList;
    }

    @Override
    @GetMapping(value = "/post/count")
    public int CountBoardList() {
        int count = boardService.countBoards();

        return count;
    }

    @Override
    @GetMapping(value = "/post/")
    public BoardFindResDto findOneBoard(Integer id) {
        boardService.viewBoard(id);
        Board b = boardService.findById(id);
        BoardFindResDto boardFindResDto = BoardFindResDto.builder()
                .id(b.getId())
                .title(b.getTitle())
                .content(b.getContent())
                .view(b.getView()).build();
        return boardFindResDto;
    }


    @Override
    @PutMapping(value = "/post")
    public void modifyBoard(String title, String content, Integer id) {
        boardService.modifyBoard(title, content, id);

    }

    @Override
    @DeleteMapping(value = "/post")
    public void destroyBoard(Integer id) {
        boardService.destroyBoard(id);
    }


}
