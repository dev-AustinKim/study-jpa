package com.oauth.kakao.exception;

import com.oauth.kakao.type.ErrorCode;

public class LoginFailedException extends RuntimeException{
    public LoginFailedException() {
        super(ErrorCode.LOGIN_FAILED.getMessage());
    }

    public LoginFailedException(String message) {
        super(message);
    }
}
