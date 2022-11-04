package com.hello.java.domain.user;

import com.hello.java.web.dto.UserSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void 사용자_저장_조회() {

        //given
        String username = "salee2";
        String password = "42gg";
        userRepository.save(UserSaveRequestDto.builder()
                .username(username)
                .password(password)
                .build().toEntity());

        //when
        List<User> users = userRepository.findAll();
        User findUser = users.get(0);

        //then
        Assertions.assertThat(findUser.getUsername()).isEqualTo(username);
        Assertions.assertThat(findUser.getPassword()).isEqualTo(password);
    }

}