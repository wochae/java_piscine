package com.example.demo.domain.user.dto;


import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class FindUserListRes {
    List<FindUserRes> userResList;
    int count;
}
