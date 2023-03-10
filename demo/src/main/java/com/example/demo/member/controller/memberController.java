package com.example.demo.member.controller;


import com.example.demo.member.domain.MemberEntity;
import com.example.demo.member.dto.request.MemberCreate;
import com.example.demo.member.dto.response.AllResponse;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@RestController
@EnableAsync
@RequestMapping("/api/member")
public class memberController {


    private final MemberService memberService;


//    @Scheduled(fixedDelay = 1000)
    @Scheduled(cron="0 13 16 3 3 ?")
    public void scheduleFixedDelayTask() throws InterruptedException {
        log.info("Fixed delay task - {}", System.currentTimeMillis() /1000);
        Thread.sleep(1000);
    }
    @GetMapping("/web-client-test")
    public Mono<Object> webClientTest(){
        WebClient client = WebClient.create();
        return client.get().uri("http://localhost:8083/api/community/aaa").retrieve().bodyToMono(Object.class);
    }

    @GetMapping("/all-by-id")
    public AllResponse allById(){
        Long loginSequence = 1L;

        return memberService.getAllById(loginSequence);
    }

    @GetMapping("/all")
    public List<MemberEntity> all(){

        return memberService.getAll();
    }

    @PostMapping("/register")
    public Long signUpMember(@RequestBody MemberCreate request){
        log.info(request.toString());
        Long memberSequence = memberService.saveMember(request);
//        log.info(HttpStatus.CREATED.toString());
        return memberSequence;
    }

    @GetMapping("/aaa")
    public ResponseEntity<Map<String,String>> aaa(){
        Map<String,String> result = new HashMap<>();
        result.put("data","앙앙앙");
        result.put("data2","앙앙앙2");

        return ResponseEntity.ok().body(result);
    }

}
