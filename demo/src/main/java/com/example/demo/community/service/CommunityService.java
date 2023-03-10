package com.example.demo.community.service;

import com.example.demo.community.domain.CommunityEntity;
import com.example.demo.community.dto.response.TitleContentResponse;
import com.example.demo.community.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CommunityService {
    private final CommunityRepository communityRepository;

    public List<CommunityEntity> getAll(){
        return communityRepository.getAllList();
    }

    public List<TitleContentResponse> getTitleAndContent(){
        return communityRepository.getTitleContent();
    }
}
