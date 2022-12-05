package com.itsse.backend.service;

import com.itsse.backend.dto.SignInResultDto;
import com.itsse.backend.dto.SignUpResultDto;

public interface SignService {
    //
    SignUpResultDto signUp(String id, String password, String name, String role);
    SignInResultDto signIn(String id, String password) throws RuntimeException;
}
