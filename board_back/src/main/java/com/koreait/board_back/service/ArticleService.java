package com.koreait.board_back.service;

import com.koreait.board_back.dto.ResponseDto;
import com.koreait.board_back.dto.article.request.ArticleCreateRequestDto;
import com.koreait.board_back.dto.article.request.ArticleUpdateRequestDto;
import com.koreait.board_back.dto.article.response.ArticleResponseDto;

public interface ArticleService {
    ResponseDto<ArticleResponseDto> createArticle(Long authorId, ArticleCreateRequestDto dto);

    ResponseDto<ArticleResponseDto> updateArticle(Long authorId, Long id, ArticleUpdateRequestDto dto);

    ResponseDto<Void> deleteArticle(Long authorId, Long id);

    ResponseDto<ArticleResponseDto> getArticle(Long id);
}
