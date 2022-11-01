package com.example.demo.domain;

import com.example.demo.domain.dto.BoardAddReqDto;
import com.example.demo.domain.dto.BoardFindResDto;
import com.example.demo.domain.dto.BoardModifyReqDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public BoardFindResDto findById(Integer id) {
        Board board = boardRepository.findById(id)
                .orElse(null);

        return new BoardFindResDto(board);
    }

    @Transactional
    public List<Board> findBoards() {
        return boardRepository.findAllDesc();
    }


    @Transactional
    public void modifyBoard(BoardModifyReqDto modifyDto) {

        Board board = boardRepository.getById(modifyDto.getId());
        board.setTitle(modifyDto.getTitle());
        board.setContent(modifyDto.getContent());
    }
}
