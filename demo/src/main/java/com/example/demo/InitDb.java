package com.example.demo;

import com.example.demo.member.dto.request.MemberCreate;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class InitDb {

    private final InitService initSerivce;

    @PostConstruct
    public void init(){
        initSerivce.init();
    }

    @RequiredArgsConstructor
    @Component
    @Transactional
    static class InitService{

        private final MemberService memberService;
        public void init(){
            saveMember();
        }
        private void saveMember() {
            for (int i = 1; i <= 10; i++) {
                MemberCreate request = makememberCreate(i);
                memberService.saveMember(request);
            }
        }

        private static MemberCreate makememberCreate(int number) {
            MemberCreate request = MemberCreate.builder()
                    .userId("test" + number)
                    .userId("test" + number)
                    .password("1234")
                    .passwordCheck("1234")
                    .username("테스트" + number)
                    .nickName("봇" + number)
                    .phone("phone" + number)
                    .email("testEmail" + number)
                    .build();

            return request;
        }
    }


}
