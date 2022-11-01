package com.example.demo.domain;

import com.example.demo.domain.dto.BoardAddReqDto;
import com.example.demo.domain.dto.BoardDtos;
import com.example.demo.domain.dto.BoardFindResDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    public BoardFindResDto findBoard() {
        BoardFindResDto boardFindResDto = BoardFindResDto.builder()
                .title(findBoard().getTitle()).content(findBoard().getContent()).build();
        return boardFindResDto;
    }

    @Transactional
    public List<Board> findBoards() {
        return boardRepository.findAllDesc();
    }
}
