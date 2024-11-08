package com.koreait.board_back.dto.auth.response;

import com.koreait.board_back.entity.User;
import lombok.Getter;

@Getter
public class SignUpResponseDto {
    private Long id;
    private String userId;
    private String name;
    private String email;

    public SignUpResponseDto(User user) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
