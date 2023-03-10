package com.example.demo.member.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="member")
@Entity
public class MemberEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_seq")
    private Long sequence;

    @Column(name="member_user_id")
    private String userId;

    @Column(name="member_password")
    private String password;

    @Column(name = "member_username")
    private String username;

    @Column(name="member_nickname")
    private String nickName;

    @Column(name="member_phone")
    private String phone;

    @Column(name="member_email")
    private String email;


    @Builder
    public MemberEntity(Long sequence, String userId, String password,
                        String username, String nickName, String phone,
                        String email) {
        this.sequence = sequence;
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.nickName = nickName;
        this.phone = phone;
        this.email = email;
    }
}
