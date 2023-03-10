package com.example.demo.community.domain;


import com.example.demo.member.domain.MemberEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "community")
@Entity
public class CommunityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_seq")
    private Long sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_seq")
    private MemberEntity member;

    @Column(name = "community_title")
    private String title;

    @Column(name = "community_content")
    @Lob
    private String content;

    @Column(name = "community_view_count")
    private Integer viewCount;

    @Column(name = "community_love_count")
    private Integer loveCount;

    @Column(name="community_created_time")
    private LocalDateTime createdTime;

    @Column(name="community_modified_time")
    private LocalDateTime modifiedTime;

    @Builder
    public CommunityEntity(Long sequence, MemberEntity member, String title, String content,
                           Integer viewCount, Integer loveCount, LocalDateTime createdTime,
                           LocalDateTime modifiedTime) {
        this.sequence = sequence;
        this.member = member;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.loveCount = loveCount;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }
}
