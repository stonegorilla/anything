package com.example.demo.member.repository;

import com.example.demo.member.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 왜 궂이 <MemberEntity , Long> 에서 Long 이 필요할까....


}
