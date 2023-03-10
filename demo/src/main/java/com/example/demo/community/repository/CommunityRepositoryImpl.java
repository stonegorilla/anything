package com.example.demo.community.repository;

import com.example.demo.community.domain.CommunityEntity;
import com.example.demo.community.dto.response.TitleContentResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.demo.community.domain.QCommunityEntity.communityEntity;
import java.util.List;


@RequiredArgsConstructor
public class CommunityRepositoryImpl implements CommunityRepositoryCustom {

    // @RequiredArgsConstructor는 final 이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
    private final JPAQueryFactory queryFactory;
    @Override
    public List<CommunityEntity> getAllList() {
        // 얘는 그냥 참고하셈 CommunityEntity 대신 Response 사용해도 되 ~ ㅎㅎ
        //        return queryFactory.select(Projections.fields(FollowResponse.class,
//                        memberFollow.toMember.sequence.as("memberSequence"), memberFollow.toMember.nickName)).
//                from(memberFollow).
//                where(memberFollow.fromMember.sequence.eq(fromSequence)).fetch();
        return queryFactory.selectFrom(communityEntity).fetch();
    }

    @Override
    public List<TitleContentResponse> getTitleContent() {
        return queryFactory.select(Projections.fields(TitleContentResponse.class,communityEntity.content.as("content"), communityEntity.title.as("title")))
                .from(communityEntity).fetch();
    }

}
