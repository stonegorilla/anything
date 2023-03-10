package com.example.demo.member.controller;


import com.example.demo.member.dto.response.FollowResponse;
import com.example.demo.member.service.FollowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/follow")
public class FollowController {

    private final FollowService followService;


    @GetMapping("/my-follow")
    public List<FollowResponse> getMyFollow(){
        Long loginSequence = 1L;
        return followService.getMyFollow(loginSequence);
    }
}
