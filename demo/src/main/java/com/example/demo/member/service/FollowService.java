package com.example.demo.member.service;

import com.example.demo.member.dto.response.FollowResponse;
import com.example.demo.member.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class FollowService {

    private final MemberService memberService;

    private final FollowRepository followRepository;


    public List<FollowResponse> getMyFollow(Long loginSequence){
        return followRepository.getMyFollow(loginSequence);
    }

}
