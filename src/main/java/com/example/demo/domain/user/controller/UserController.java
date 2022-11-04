package com.example.demo.domain.user.controller;


import com.example.demo.domain.user.dto.PostUserReq;
import com.example.demo.domain.user.dto.PostUserRes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface UserController {

    /**
     * 회원가입
     * [POST] /user/create
     * @return PostUserRes
     */

    public PostUserRes createUser(@RequestBody PostUserReq req);
}
