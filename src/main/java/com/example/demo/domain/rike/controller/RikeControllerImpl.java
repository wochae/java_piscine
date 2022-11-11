package com.example.demo.domain.rike.controller;

import com.example.demo.domain.rike.RikeService;
import com.example.demo.domain.rike.dto.RikeReq;
import com.example.demo.domain.rike.dto.RikeRes;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/board/rike/")
public class RikeControllerImpl implements RikeController{

    private final RikeService rikeService;

    @PostMapping(value = "up")
    public RikeRes RikeBoard(RikeReq req) {


        return null;
    }

}

