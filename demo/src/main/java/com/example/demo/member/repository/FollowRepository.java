package com.example.demo.member.repository;

import com.example.demo.member.domain.MemberFollow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<MemberFollow,Long>, FollowRepositoryCustom {
}
