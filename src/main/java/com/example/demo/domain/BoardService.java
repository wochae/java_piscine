package com.example.demo.domain;

import com.example.demo.domain.dto.BoardAddReqDto;
import com.example.demo.domain.dto.BoardFindResDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

    private BoardRepository boardRepository;


    @Transactional
    public void addBoard(BoardAddReqDto addDto) {
        Board board = Board.builder()
                        .title(addDto.getTitle()).content(addDto.getContent()).build();
        boardRepository.save(board);
    }

    @Transactional
    public BoardFindResDto findBoard(Integer id) {
        BoardFindResDto boardFindResDto = BoardFindResDto.builder()
                .title(findBoard(id).getTitle()).content(findBoard(id).getContent()).build();
        return boardFindResDto;
    }

    @Transactional
    public List<Board> findBoards() {
        return boardRepository.findAllDesc();
    }
}
