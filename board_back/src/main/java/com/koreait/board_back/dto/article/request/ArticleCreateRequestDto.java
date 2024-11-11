package com.koreait.board_back.dto.article.request;

import lombok.Getter;

@Getter
public class ArticleCreateRequestDto {
    private String title;
    private String content;
}
