package com.example.demo.domain.user.controller;

import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserProvider;
import com.example.demo.domain.user.UserService;
import com.example.demo.domain.user.dto.*;
import com.example.demo.global.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.utils.ValidationRegex.isRegexEmail;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserControllerImpl implements UserController{

    private final UserService userService;
    private final UserProvider userProvider;


    @Override
    @PostMapping(value = "/create")
    public PostUserRes createUser(PostUserReq req) {
        if (req.getEmail() == null) {
            throw new BusinessException("");
        }
        if (!isRegexEmail(req.getEmail())) {
            throw new BusinessException("");
        }
        PostUserRes res;
        try {
            res = userService.createUser(req);
        } catch (BusinessException exception) {
            throw new BusinessException("생성에 실패했습니다.");
        }
        return res;
    }

    @Override
    @GetMapping(value = "/find")
    public List<FindUserRes> findUser(String name) {
        List<FindUserRes> res = userService.findUser(name);
        return res;
    }


    @Override
    @GetMapping(value = "/all")
    public FindUserListRes findUserList() {
        List<User> list = userService.findUsers();
        List<FindUserRes> resList = new ArrayList<>();
        for (User u : list) {
            resList.add(FindUserRes.builder().userName(u.getUserName())
                                            .email(u.getEmail()).password(u.getPassword()).build());
        }
        FindUserListRes res = FindUserListRes.builder().userResList(resList).count(resList.size()).build();
        return res;
    }
    @Override
    @GetMapping(value = "/edit")
    public UpdateUserRes UpdateUser(UpdateUserReq req) {
        if (userProvider.checkEmail(req.getEmail()) == 0) {
            throw new IllegalArgumentException("이메일이 이상한데?");
        }
        User user = userService.findUserByName(req.getName());
        if (user.getPassword() != req.getPassword()) {
            throw new IllegalArgumentException("비밀번호가 틀립니다.");
        }
        UpdateUserRes res = UpdateUserRes.builder().name(user.getUserName()).email(user.getEmail()).build();
        res.setEmail(req.getEmail());


        return res;
    }
}
