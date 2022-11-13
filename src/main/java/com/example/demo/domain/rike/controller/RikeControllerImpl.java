package com.example.demo.domain.rike.controller;

import com.example.demo.domain.rike.Rike;
import com.example.demo.domain.rike.RikeService;
import com.example.demo.domain.rike.dto.RikeReq;
import com.example.demo.domain.rike.dto.RikeRes;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/board/post/rike")
public class RikeControllerImpl implements RikeController{

    private final RikeService rikeService;

    @GetMapping(value = "/all")
    public List<RikeRes> RikeBoard() {
        List<RikeRes> list = new ArrayList();
        List<Rike> resList = rikeService.findAllRike();
        for (Rike r : resList) {
            RikeRes res = RikeRes.builder().rikeId(r.getId()).boardId(r.getBoard().getId()).userId(r.getUser().getId()).build();
            list.add(res);
        }
        return list;
    }

}

