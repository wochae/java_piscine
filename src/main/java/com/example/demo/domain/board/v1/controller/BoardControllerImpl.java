package com.example.demo.domain.board.v1.controller;


import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.BoardRepository;
import com.example.demo.domain.board.BoardService;
import com.example.demo.domain.board.v1.dto.BoardAddReqDto;
import com.example.demo.domain.board.v1.dto.BoardDeleteBySelfReq;
import com.example.demo.domain.board.v1.dto.BoardListDto;
import com.example.demo.domain.board.v1.dto.BoardAddTagReqDto;
import com.example.demo.domain.rike.Rike;
import com.example.demo.domain.rike.RikeRepository;
import com.example.demo.domain.rike.RikeService;
import com.example.demo.domain.rike.dto.RikeReq;
import com.example.demo.domain.rike.dto.RikeRes;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserRepository;
import com.example.demo.domain.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    private final RikeService rikeService;

    private final RikeRepository rikeRepository;


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
    @GetMapping(value = "/post/find/p/{userName}")
    public Page<Board> findBoardPageByUserName(String userName, Pageable pageable) {
        Page<Board> pages = boardService.pageList(userName, pageable);
        return pages;
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
    @PostMapping(value = "/post/rike/u")
    public void increaseBoardLike(RikeReq req) {
        if (req.getBoardId() == null || req.getUserId() == null) {
            throw new IllegalArgumentException("error");
        }
//        if (rikeService.isExistsRike(req) != null)// 존재하면 안되기 때문에 존재한다면 에러 처리
//            throw new IllegalArgumentException("좋아요를 할 수 없습니다.");


        Board b = boardRepository.getById(req.getBoardId());
        User u = userRepository.getById(req.getUserId());

        Rike rike = new Rike(b, u);
        rikeService.rikeUp(rike);

    }

    @Override
    @DeleteMapping(value = "/post/rike/d")
    public void decreaseBoardLike(RikeReq req) {
        if (req.getBoardId() == null || req.getUserId() == null) {
            throw new IllegalArgumentException("error");
        }
        if (rikeService.isExistsRike(req) == null) { // 존재하면 안되기 때문에 존재한다면 에러 처리
            throw new IllegalArgumentException("좋아요를 취소할 수 없습니다.");
        }
        Board b = boardRepository.getById(req.getBoardId());
        User u = userRepository.getById(req.getUserId());

        Rike rike = new Rike(b, u);
        rikeService.rikeDown(rike);
    }

    @Override
    @PutMapping(value = "/post/tag")
    public BoardAddTagReqDto addTagInBoard(BoardAddTagReqDto reqDto) {
        BoardAddTagReqDto res = boardService.addTag(reqDto);
        return res;
    }
}
