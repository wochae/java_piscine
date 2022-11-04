package com.example.demo.domain.board.v1.controller;


import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.BoardService;
import com.example.demo.domain.board.v1.dto.BoardListDto;
import com.example.demo.domain.board.v1.dto.addTagReqDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    public BoardListDto findAllBoardDesc() {
        List<Board> boards = boardService.findBoards();


        List<Board> boardList = new ArrayList<>();
        for (Board board : boards) {
            boardList.add(board);
        }

        BoardListDto listDto = BoardListDto.builder().BoardList(boardList).countBoard(boards.size()).build();


        return listDto;
    }


    @Override
    @GetMapping(value = "/post/")
    public Board findOneBoard(Integer id) {
        boardService.viewBoard(id);
        Board b = boardService.findById(id);

        return b;
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



    @Override
    @PutMapping(value = "/post/rike/u")
    public void increaseBoardLike(Integer id) {
        boardService.increaseLike(id);
    }

    @Override
    @PutMapping(value = "/post/rike/d")
    public void decreaseBoardLike(Integer id) {
        boardService.decreaseLike(id);
    }

    @Override
    @PutMapping(value = "/post/tag")
    public addTagReqDto addTagInBoard(addTagReqDto reqDto) {
        addTagReqDto res = boardService.addTag(reqDto);
        return res;
    }
}
