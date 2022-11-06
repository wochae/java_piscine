package com.example.demo.domain.board;

import com.example.demo.domain.board.v1.dto.BoardAddTagReqDto;
import com.example.demo.domain.board.v1.dto.BoardDeleteBySelfReq;
import com.example.demo.domain.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    @Transactional
    public void addBoard(Board board) {
        Board b = Board.builder()
                        .title(board.getTitle())
                        .content(board.getContent())
                        .user(board.getUser())
                        .view(0)
                        .like(0)
                        .build();
        boardRepository.save(b);
    }

    @Transactional
    public Board findById(Integer id) {
        Board board = boardRepository.findById(id)
                .orElse(null);

        return board;
    }

    @Transactional
    public List<Board> findBoards() {
        return boardRepository.findAllDesc();
    }

    public int countBoards() {
        return boardRepository.findAllDesc().size();
    }


    @Transactional
    public void modifyBoard(String title, String content, Integer id) {
        Optional<Board> board = boardRepository.findById(id);
        Board newBoard = board.get();
        newBoard.setTitle(title);
        newBoard.setContent(content);

    }
    @Transactional
    public void destroyBoard(Integer id) {
        Board board = findById(id);
        boardRepository.delete(board);
    }
    @Transactional
    public void viewBoard(Integer id) {
        Board findBoard = findById(id);
        findBoard.setView(findBoard.getView() + 1);
    }

    @Transactional
    public void increaseLike(Integer id) {
        Board findBoard = findById(id);
        findBoard.setLike(findBoard.getLike() + 1);
    }
    @Transactional
    public void decreaseLike(Integer id) {
        Board findBoard = findById(id);
        findBoard.setLike(findBoard.getLike() - 1);
    }

    @Transactional
    public BoardAddTagReqDto addTag(BoardAddTagReqDto reqDto) {
        Board findBoard = findById(reqDto.getBoardId());
        findBoard.setTag(reqDto.getTag());

        BoardAddTagReqDto res = BoardAddTagReqDto.builder().
                            boardId(findBoard.getId()).
                            tag(findBoard.getTag()).build();
        return res;

    }

    public void deleteBySelf(BoardDeleteBySelfReq req, User user) {

        List<Board> boardList = boardRepository.findBoardsByUserId(user.getId());

        Board board = boardList.stream().filter(e -> e.getId()==req.getBoardId()).findAny().orElseThrow();

        boardRepository.delete(board);
    }
}
