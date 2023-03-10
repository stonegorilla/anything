package com.example.demo.member.exception;

import com.example.demo.exception.CustomException;

public class MemberNotFound extends CustomException {
    // CustomException은 일단 나중에 ㄱㄱ
    private static final String MESSAGE = "존재하지 않는 회원입니다.";

    public MemberNotFound(){super(MESSAGE);}

    public MemberNotFound(String message, Throwable cause){super(message,cause);}

    @Override
    public int getStatusCode(){return 404;}

}
