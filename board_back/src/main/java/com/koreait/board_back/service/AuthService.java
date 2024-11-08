package com.koreait.board_back.service;

import com.koreait.board_back.dto.ResponseDto;
import com.koreait.board_back.dto.auth.request.LoginRequestDto;
import com.koreait.board_back.dto.auth.request.SignUpRequestDto;
import com.koreait.board_back.dto.auth.response.LoginResponseDto;
import com.koreait.board_back.dto.auth.response.SignUpResponseDto;

public interface AuthService {
    ResponseDto<SignUpResponseDto> signUp(SignUpRequestDto dto);

    ResponseDto<LoginResponseDto> login(LoginRequestDto dto);
}
