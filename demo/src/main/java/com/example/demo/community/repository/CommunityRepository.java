package com.example.demo.community.repository;

import com.example.demo.community.domain.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<CommunityEntity, Long> , CommunityRepositoryCustom{
}
