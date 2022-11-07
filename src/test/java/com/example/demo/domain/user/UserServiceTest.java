package com.example.demo.domain.user;

import com.example.demo.domain.user.dto.PostUserReq;
import com.example.demo.domain.user.dto.PostUserRes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserProvider userProvider;



    @Transactional
    @Test
    void createUser() {
        // res email, id
        // req name, email. pw

        //given
        PostUserReq req = new PostUserReq("flash", "flash@justice.com", "1234");


        //when
        PostUserRes res = userService.createUser(req);

        //then
        User user = userService.findUserByEmail("flash@justice.com");

        PostUserRes diff = PostUserRes.builder().email(user.getEmail()).id(user.getId()).build();
        assertThat(res.getId()).isEqualTo(diff.getId());

    }

    @Test
    void findUser() {
    }

    @Test
    void findUserByName() {
    }

    @Test
    void findUserByEmail() {
    }

    @Test
    void findById() {
    }

    @Test
    void findUsers() {
    }

    @Test
    void updateUser() {
    }
}