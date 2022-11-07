package com.hello.java.web.controller;

import com.hello.java.service.UserService;
import com.hello.java.web.dto.UserSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public Long save(@RequestParam UserSaveRequestDto requestDto) {
        return userService.join(requestDto.toEntity());
    }
}
