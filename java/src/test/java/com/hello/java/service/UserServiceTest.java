package com.hello.java.service;

import com.hello.java.domain.user.User;
import com.hello.java.domain.user.UserRepository;
import com.hello.java.web.dto.UserSaveRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;


@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void 유저가_생성된다() {

        //given
        String username = "salee2";
        String password = "42gg";

        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .username(username)
                .password(password)
                .build();

        //when
        Long userId = userService.save(requestDto);
        User findUser = userRepository.findById(userId).orElseThrow();

        //then
        assertThat(findUser.getUsername()).isEqualTo(username);
        assertThat(findUser.getPassword()).isEqualTo(password);
    }
}