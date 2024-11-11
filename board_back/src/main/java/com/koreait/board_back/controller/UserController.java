package com.koreait.board_back.controller;

import com.koreait.board_back.common.ApiMappingPattern;
import com.koreait.board_back.dto.ResponseDto;
import com.koreait.board_back.dto.user.request.UpdateUserRequestDto;
import com.koreait.board_back.dto.user.response.UserResponseDto;
import com.koreait.board_back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiMappingPattern.USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<ResponseDto<UserResponseDto>> getUserInfo(@AuthenticationPrincipal String userId) {
        ResponseDto<UserResponseDto> response = userService.getUserInfo(userId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }

    @PutMapping
    public ResponseEntity<ResponseDto<UserResponseDto>> updateUser(@AuthenticationPrincipal String userId, @RequestBody UpdateUserRequestDto dto) {
        ResponseDto<UserResponseDto> response = userService.updateUser(userId, dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<Void>> deleteUser(@AuthenticationPrincipal String userId) {
        ResponseDto<Void> response = userService.deleteUser(userId);
        // NO_CONTENT: content 없음(NOT_FOUND: 찾을 수 없음 - error)
        HttpStatus status = response.isResult() ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }
}
