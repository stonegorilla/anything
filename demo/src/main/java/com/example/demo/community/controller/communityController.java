package com.example.demo.community.controller;

import com.example.demo.community.domain.CommunityEntity;
import com.example.demo.community.dto.response.TitleContentResponse;
import com.example.demo.community.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/community")
public class communityController {
    private final CommunityService communityService;

    @GetMapping("/board-all")
    public List<CommunityEntity> boardAll(){
        return communityService.getAll();
    }

    @GetMapping("/board-title")
    public List<TitleContentResponse> boardTitle(){
        return communityService.getTitleAndContent();
    }
}
