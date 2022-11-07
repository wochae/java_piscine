package com.example.demo.domain.board.v1.controller;


import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.BoardRepository;
import com.example.demo.domain.board.BoardService;
import com.example.demo.domain.board.v1.dto.BoardAddReqDto;
import com.example.demo.domain.board.v1.dto.BoardDeleteBySelfReq;
import com.example.demo.domain.board.v1.dto.BoardListDto;
import com.example.demo.domain.board.v1.dto.BoardAddTagReqDto;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserRepository;
import com.example.demo.domain.user.UserService;
import com.example.demo.domain.user.dto.FindUserRes;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/board")
public class BoardControllerImpl implements BoardController {

    private final BoardService boardService;

    private final BoardRepository boardRepository;
    private final UserService userService;
    private final UserRepository userRepository;


    @Override
    @PostMapping(value = "/post")
    public void saveBoard(BoardAddReqDto req) {
        try {
            User user = userRepository.getById(req.getUserId());
            Board board = new Board(req.getTitle(), req.getContent(), user, 0, 0);
            boardService.addBoard(board);
        } catch (Exception exception) {
            throw new IllegalArgumentException("계정을 찾을 수 없습니다.");
        }
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
    @GetMapping(value = "/post/find/{userName}")
    public BoardListDto findBoardsByName(String userName) {

        List<Board> boards = boardService.findBoardsByUserName(userName);
        List<Board> boardList = new ArrayList<>(boards);

        return BoardListDto.builder().BoardList(boardList).countBoard(boards.size()).build();
    }


    @Override
    @GetMapping(value = "/post/")
    public Board findOneBoard(Integer id) {
        boardService.viewBoard(id);
        Board b = boardService.findById(id);

        return b;
    }

    @Override
    @DeleteMapping(value = "/post/delete")
    public void deleteBoardBySelf(BoardDeleteBySelfReq req) {
        try {
            User u = userService.findUserByEmail(req.getEmail());
        } catch (Exception e) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
        User user = userService.findUserByEmail(req.getEmail());
        String pw = user.getPassword();

        if (!pw.equals(req.getPassword()))
            throw new IllegalArgumentException("비밀번호가 맞지 않습니다.");
        try {
            boardService.deleteBySelf(req, user);
        } catch (Exception e) {
            throw new IllegalArgumentException("게시글을 삭제할 수 없습니다.");
        }
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
    public BoardAddTagReqDto addTagInBoard(BoardAddTagReqDto reqDto) {
        BoardAddTagReqDto res = boardService.addTag(reqDto);
        return res;
    }
}
