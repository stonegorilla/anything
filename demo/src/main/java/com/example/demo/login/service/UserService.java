package com.example.demo.login.service;

import com.example.demo.login.domain.User;
import com.example.demo.login.dto.RegisterDto;
import com.example.demo.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 원래 Response 만들어서 해줘
    public User register(RegisterDto registerDto){
        User user = new User();
        // 이렇게 set을 써도 되고, user에 Builder 써도 되고
        user.setName(registerDto.getName());
        user.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));
        user.setUsername(registerDto.getUsername());
        user.setRoles("ROLE_USER");
        return userRepository.save(user);

    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findUser(int id){
        return userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("User ID를 찾을 수 없습니다.");
        });
    }
}
