package com.example.demo.domain.user;

import com.example.demo.domain.user.dto.*;
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
            FindUserRes res = FindUserRes.builder().userName(u.getUserName()).email(u.getEmail()).password(u.getPassword()).build();
            list.add(res);
        }

        return list;
    }
    public User findUserByName(String name) {
        return userRepository.findByUserName(name).orElse(null);
    }

    public User findUserByEmail(String email) {
        return userRepository.findFirstByEmail(email).orElse(null);
    }

    public FindUserRes findById(Integer userId) {
       Optional<User> user = Optional.of(userRepository.getById(userId));
        FindUserRes res = FindUserRes.builder().userName(user.get().getUserName()).email(user.get().getEmail()).build();
       return res;
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public UpdateUserRes updateUser(UpdateUserReq req) {
        userRepository.getById(req.getId()).setUserName(req.getName());
        User user = userRepository.getById(req.getId());
        UpdateUserRes res = UpdateUserRes.builder().email(user.getEmail()).name(user.getUserName()).build();

        return res;

    }
}
