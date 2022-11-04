package com.example.demo.domain.user;

import com.example.demo.domain.user.dto.FindUserListRes;
import com.example.demo.domain.user.dto.FindUserRes;
import com.example.demo.domain.user.dto.PostUserReq;
import com.example.demo.domain.user.dto.PostUserRes;
import com.example.demo.global.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserProvider userProvider;

    public PostUserRes createUser(PostUserReq req) {
        if (userProvider.checkEmail(req.getEmail()) == 0) {
            throw new IllegalStateException("중복되는 이메일 입니다");
        }
        PostUserRes res;
        try {
            res = userProvider.createUser(req);
        } catch (BusinessException exception) {
            throw new IllegalStateException("생성 실패");
        }
        return res;
    }

    public List<FindUserRes> findUser(String userName) {
        List<User> user = userRepository.findUserByUserName(userName);
        List<FindUserRes> list = new ArrayList<>();
        for (User u : user) {
            FindUserRes res = FindUserRes.builder().userName(u.getUserName()).email(u.getEmail()).build();
            list.add(res);
        }

        return list;
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

}
