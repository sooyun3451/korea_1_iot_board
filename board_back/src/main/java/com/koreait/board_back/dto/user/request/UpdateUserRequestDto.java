package com.koreait.board_back.dto.user.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UpdateUserRequestDto {
    private String email;
    private String name;
    private String phone;
}
