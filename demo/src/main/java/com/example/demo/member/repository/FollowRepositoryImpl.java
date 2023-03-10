package com.example.demo.member.repository;



import com.example.demo.member.dto.response.FollowResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import static com.example.demo.member.domain.QMemberEntity.memberEntity;
import static com.example.demo.member.domain.QMemberFollow.memberFollow;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FollowRepositoryImpl implements FollowRepositoryCustom{

    // 얘가 querydsl 이구먼
    private final JPAQueryFactory queryFactory;

    @Override
    public List<FollowResponse> getMyFollow(Long fromSequence) {

        // memberFollow.toMember..... 여기부분은 FollowResponse에 차례대로 들어가면됨
        // 여기서 memberSequence 는 FollowResponse에 있는 이름과 같아야 함 ㅎㅎ 아니면 entity에 있는 이름이 들어감 ㅎㅎ
        return queryFactory.select(Projections.fields(FollowResponse.class,
                memberFollow.toMember.sequence.as("memberSequence"), memberFollow.toMember.nickName)).
                from(memberFollow).
                where(memberFollow.fromMember.sequence.eq(fromSequence)).fetch();
        // 여기서 .join(memberFollow.fromMember,memberEntitiy).fetchJoin() 을 해주어야 하는가....


    }
}
