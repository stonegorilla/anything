package com.example.demo.login.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, unique = true)
    private String username;

    @JsonIgnore
    @Column(nullable = true)
    private String password;

    @Column(nullable = false, unique=true)
    private String name;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "provider", nullable = true)
    private String provider;

    private String roles; // USER, ADMIN (왜  @Column을 뺏을까?)

    @Builder //생성을 Builder 패턴으로 하기 위해서
    public User(Long id, String name, String email, String provider, String nickname) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.roles = nickname;
    }
    public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public User update(String name, String email) {
        this.name = name;
        this.email = email;
        return this;
    }
}
