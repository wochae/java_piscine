package com.example.demo.domain.user;

import com.example.demo.domain.user.dto.PostUserReq;
import com.example.demo.domain.user.dto.PostUserRes;
import com.example.demo.global.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserProvider {

    private final UserRepository userRepository;


    public int checkEmail(String email) throws BusinessException {
        if (userRepository.findFirstByEmail(email).isPresent())
            return 0;
        return 1;
    }

    public PostUserRes createUser(PostUserReq req) {
        User user = User.builder().userName(req.getUserName()).password(req.getPassword()).email(req.getEmail()).build();

        userRepository.save(user);
        PostUserRes res = new PostUserRes(user.getEmail(), user.getId());
        return res;
    }
}
