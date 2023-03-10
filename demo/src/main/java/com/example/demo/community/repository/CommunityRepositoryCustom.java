package com.example.demo.community.repository;

import com.example.demo.community.domain.CommunityEntity;
import com.example.demo.community.dto.response.TitleContentResponse;

import java.util.List;

public interface CommunityRepositoryCustom {

    List<CommunityEntity> getAllList();

    List<TitleContentResponse> getTitleContent();
}
