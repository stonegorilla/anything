package com.example.demo.login.controller;

import com.example.demo.login.domain.User;
import com.example.demo.login.dto.RegisterDto;
import com.example.demo.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/auth")
    public void register(@RequestBody RegisterDto registerDto){
        userService.register(registerDto);
    }
}
