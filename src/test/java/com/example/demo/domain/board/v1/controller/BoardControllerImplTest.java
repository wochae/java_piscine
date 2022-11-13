package com.example.demo.domain.board.v1.controller;

import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.BoardRepository;
import com.example.demo.domain.board.BoardService;

import com.example.demo.domain.board.v1.dto.BoardDeleteBySelfReq;
import com.example.demo.domain.rike.dto.RikeReq;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserRepository;
import com.example.demo.domain.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@Transactional
@SpringBootTest
class BoardControllerImplTest {

    @Autowired
    BoardControllerImpl boardController;
    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    Integer userId1;
    Integer userId2;
    User u1;
    User u2;

    Board b;

    Integer boardId1;

    void init(){
        u1 = new User("wonder", "wonder@jsl.com", "1234");
        u2 = new User("aqua", "aquq@jsl.com", "1234");
        userRepository.save(u1);
        userRepository.save(u2);
        b = new Board("wonder", "hi", u1, 0, 0);
        userId1 = u1.getId();
        userId2 = u2.getId();
        boardRepository.save(b);
        boardId1 = boardRepository.findBoardsByUserId(userId1).get(0).getId();
    }

    @Test
    void saveBoard() {
    }

    @Test
    void findAllBoardDesc() {
    }

    @Test
    void findOneBoard() {
        /*
        // given
        Board board = new Board();

        // when
        Integer id = boardRepository.save(board).getId();
        Board origin1 = boardService.findById(id);
        int beforeView = origin1.getView();
        boardService.viewBoard(id);

        // 왜 origin 으로 따로 값을 넣어줘야 비교할 수 있나
        // then
        Board origin2 = boardService.findById(id);
        int afterView = origin2.getView();
        Assertions.assertThat(afterView).isEqualTo(beforeView + 1);
        */
    }

    @Transactional
    @Test
    void modifyBoard() {
    }

    @Transactional
    @Test
    void deleteBoardBySelf_이메일이_잘못된_경우() {

        //given
        init();
        Integer boardId = b.getId();
        BoardDeleteBySelfReq req = new BoardDeleteBySelfReq("wonderpark@jsl.com", "1234", boardId);

        //when

//        boardController.deleteBoardBySelf(req);

        //then

        Assertions.assertThatThrownBy(() -> boardController.
                            deleteBoardBySelf(req)).isInstanceOf(new IllegalArgumentException("사용자를 찾을 수 없습니다.").getClass());

    }

    @Transactional
    @Test
    void deleteBoardBySelf_비밀번호가_잘못_된_경우() {

        //given
        init();
        Integer boardId = b.getId();
        BoardDeleteBySelfReq req = new BoardDeleteBySelfReq("wonder@jsl.com", "1233", boardId);

        //when

//        boardController.deleteBoardBySelf(req);

        //then

        Assertions.assertThatThrownBy(() -> boardController.
                deleteBoardBySelf(req)).isInstanceOf(new IllegalArgumentException("비밀번호가 맞지 않습니다.").getClass());

    }

    @Transactional
    @Test
    void deleteBoardBySelf1_삭제할_권한이_없는_유저() {

        //given
        init();
        Integer boardId = b.getId();
        BoardDeleteBySelfReq req = new BoardDeleteBySelfReq("aqua@jsl.com", "1234", boardId);



        Assertions.assertThatThrownBy(() -> boardController.
                deleteBoardBySelf(req)).isInstanceOf(new IllegalArgumentException("게시글을 삭제할 수 없습니다.").getClass());

    }


    @Test
    void increaseBoardLike_내가_이미_좋아요한_게시글() {
        // given
        init();
        Integer boardId = boardId1;
        RikeReq req = new RikeReq(userId2, boardId);
        boardController.increaseBoardLike(req);

        // given

        // then
        Assertions.assertThatThrownBy(() -> boardController.
                increaseBoardLike(req)).isInstanceOf(new IllegalArgumentException("좋아요을 할 수 없습니다.").getClass());

    }

    @Test
    void increaseBoardLike_노멀() {
        init();
        Integer boardId = boardId1;
    }
    @Test
    void decreaseBoardLike_내가_좋아요를_안했는데() {
        // given
        init();
        Integer boardId = boardId1;
        RikeReq req = new RikeReq(userId2, boardId);
        boardController.increaseBoardLike(req);

        // when
        Assertions.assertThatThrownBy(() -> boardController.
                increaseBoardLike(req)).isInstanceOf(new IllegalArgumentException("좋아요을 할 수 없습니다.").getClass());
    }

    @Test
    void decreaseBoardLike_노말() {
    }

    @Test
    void boardRikeByUser() {
    }
}