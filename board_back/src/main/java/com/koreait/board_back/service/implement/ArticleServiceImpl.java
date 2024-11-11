package com.koreait.board_back.service.implement;

import com.koreait.board_back.dto.ResponseDto;
import com.koreait.board_back.dto.article.request.ArticleCreateRequestDto;
import com.koreait.board_back.dto.article.request.ArticleUpdateRequestDto;
import com.koreait.board_back.dto.article.response.ArticleResponseDto;
import com.koreait.board_back.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public ResponseDto<ArticleResponseDto> createArticle(Long authorId, ArticleCreateRequestDto dto) {
        return null;
    }

    @Override
    public ResponseDto<ArticleResponseDto> updateArticle(Long authorId, Long id, ArticleUpdateRequestDto dto) {
        return null;
    }

    @Override
    public ResponseDto<Void> deleteArticle(Long authorId, Long id) {
        return null;
    }

    @Override
    public ResponseDto<ArticleResponseDto> getArticle(Long id) {
        return null;
    }
}
