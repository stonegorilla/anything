package com.example.demo.member.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
public class AllResponse {

    private Long memberSequence;

    private String userId;
    private String userName;
    private String nickName;

    private String phone;
    private String email;

    private String[] category;

    private String dream;

    private String status;

    private Long imageSequence;

    private int badgeCount;
    private String level;

    @Builder
    public AllResponse(Long memberSequence, String userId, String userName, String nickName,
                       String phone, String email, String[] category,
                       String dream, String status, Long imageSequence, int badgeCount, String level) {
        this.memberSequence = memberSequence;
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.phone = phone;
        this.email = email;
        this.category = category;
        this.dream = dream;
        this.status = status;
        this.imageSequence = imageSequence;
        this.badgeCount = badgeCount;
        this.level = level;
    }
}
