package com.example.demo.member.repository;

import com.example.demo.member.dto.response.FollowResponse;

import java.util.List;

public interface FollowRepositoryCustom {

    List<FollowResponse> getMyFollow(Long fromSequence);
}
