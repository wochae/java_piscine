package com.example.demo.domain.user.controller;


import com.example.demo.domain.user.User;
import com.example.demo.domain.user.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {

    /**
     * 회원가입
     * [POST] /user/create
     * @return PostUserRes
     */

    public PostUserRes createUser(@RequestBody PostUserReq req);

//    public UpdateUserRes findUser(@RequestBody UpdateUserReq req);

    public List<FindUserRes> findUser(@RequestParam String userName);


    public FindUserListRes findUserList();

    UpdateUserRes UpdateUser(@RequestBody UpdateUserReq req);
}
