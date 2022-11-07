package com.hello.java.service;

import com.hello.java.domain.user.User;
import com.hello.java.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    /*
        회원 가입
     */
    @Transactional
    public Long join(User user) {

        verifyDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void verifyDuplicateUser(User user) {
        userRepository.findByName(user.getUsername())
                .ifPresent(u -> {
                    throw new IllegalIdentifierException("이미 존재하는 회원입니다.");
                });
    }

}
