package com.example.demo.member.service;

import com.example.demo.member.domain.MemberEntity;
import com.example.demo.member.dto.request.MemberCreate;
import com.example.demo.member.dto.response.AllResponse;
import com.example.demo.member.exception.MemberNotFound;
import com.example.demo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;


    public AllResponse getAllById(Long loginSequence){
        MemberEntity findMember = memberRepository.findById(loginSequence)
                .orElseThrow(() -> new MemberNotFound());
        return createMypageResponse(findMember);
    }

    public List<MemberEntity> getAll(){
        List<MemberEntity> findMemberAll = memberRepository.findAll();
        return findMemberAll;
    }

    @Transactional
    public Long saveMember(MemberCreate request){
        MemberEntity member = request.toEntity();
//        log.info(member.getSequence().toString());
        memberRepository.save(member);  // 여기서 save 함으로써 database 갔다오고 나서 entity인 member의 sequence 도 하나 올려줌
//        log.info(member.getSequence().toString());
        return member.getSequence();
    }
    private AllResponse createMypageResponse(MemberEntity member){



        return AllResponse.builder().memberSequence(member.getSequence()).userId(member.getUserId()).nickName(member.getNickName()).
                phone(member.getPhone()).email(member.getEmail()).
                badgeCount(53).
                level("중수").category(new String[]{"frontend","backend"})
                .imageSequence(55L).dream("백조").status("온라인").build();



    }
}
