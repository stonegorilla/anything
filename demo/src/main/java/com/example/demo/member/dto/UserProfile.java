package com.example.demo.member.dto;

import com.example.demo.login.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {

    private String name;
    private String email;
    private String provider;
    private String nickname;

    public User toMember() {
        return User.builder()
                .name(name)
                .email(email)
                .provider(provider)
                .build();
    }
}
