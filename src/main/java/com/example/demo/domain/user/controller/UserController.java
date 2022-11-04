package com.example.demo.domain.user.controller;


import com.example.demo.domain.user.User;
import com.example.demo.domain.user.dto.FindUserListRes;
import com.example.demo.domain.user.dto.FindUserRes;
import com.example.demo.domain.user.dto.PostUserReq;
import com.example.demo.domain.user.dto.PostUserRes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface UserController {

    /**
     * 회원가입
     * [POST] /user/create
     * @return PostUserRes
     */

    public PostUserRes createUser(@RequestBody PostUserReq req);

    public List<FindUserRes> findUser(@RequestParam String userName);

    public FindUserListRes findUserList();
}
