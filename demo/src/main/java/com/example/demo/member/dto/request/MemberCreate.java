package com.example.demo.member.dto.request;

import com.example.demo.member.domain.MemberEntity;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

// @Data 꼭 붙여야 하나
public class MemberCreate {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordCheck;


    private String username;


    private String nickName;

    private String phone;

    private String email;

//    @Builder
//    public MemberCreate(String userId, String password, String passwordCheck,
//                        String username, String nickname, String phone, String email) {
//        this.userId = userId;
//        this.password = password;
//        this.passwordCheck = passwordCheck;
//        this.username = username;
//        this.nickname = nickname;
//        this.phone = phone;
//        this.email = email;
//    }


    // 이렇게 하면 어떻게 되나
    @Builder
    public MemberCreate(String userId, String password, String passwordCheck,
                        String username, String nickName, String phone, String email) {
        this.userId = userId;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.username = username;
        this.nickName = nickName;
        this.phone = phone;
        this.email = email;
    }

    public MemberEntity toEntity(){
        return MemberEntity.builder().userId(userId).password(password)
                .username(username).nickName(nickName).phone(phone).email(email).build();
    }
}
