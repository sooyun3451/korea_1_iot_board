package com.koreait.board_back.service.implement;

import com.koreait.board_back.common.ResponseMessage;
import com.koreait.board_back.dto.ResponseDto;
import com.koreait.board_back.dto.article.request.ArticleCreateRequestDto;
import com.koreait.board_back.dto.article.request.ArticleUpdateRequestDto;
import com.koreait.board_back.dto.article.response.ArticleResponseDto;
import com.koreait.board_back.entity.Article;
import com.koreait.board_back.repository.ArticleRepository;
import com.koreait.board_back.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public ResponseDto<ArticleResponseDto> createArticle(Long authorId, ArticleCreateRequestDto dto) {
        ArticleResponseDto data = null;
        String title = dto.getTitle();
        String content = dto.getContent();

        try {
            Article article = Article.builder()
                    .title(title)
                    .content(content)
                    .authorId(authorId)
                    .build();
            articleRepository.save(article);

            data = new ArticleResponseDto(article);

        }catch(Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    @Override
    public ResponseDto<ArticleResponseDto> updateArticle(Long authorId, Long id, ArticleUpdateRequestDto dto) {
        ArticleResponseDto data = null;
        String title = dto.getTitle();
        String content = dto.getContent();
        Long articleId = id;

        try {
            Optional<Article> optionalArticle = articleRepository.findByIdAndAuthorId(articleId, authorId);

            if(optionalArticle.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_POST);
            }

            Article article = optionalArticle.get();
            article.toBuilder()
                    .title(title)
                    .content(content)
                    .build();
            articleRepository.save(article);

            data = new ArticleResponseDto(article);

        }catch(Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    @Override
    public ResponseDto<Void> deleteArticle(Long authorId, Long id) {
        Long articleId = id;

        try {
            Optional<Article> optionalArticle = articleRepository.findByIdAndAuthorId(articleId, authorId);

            if(optionalArticle.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_POST);
            }

            Article article = optionalArticle.get();
            articleRepository.delete(article);

        }catch(Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, null);
    }

    // 일반 조회
    @Override
    public ResponseDto<ArticleResponseDto> getArticle(Long id) {
        ArticleResponseDto data = null;
        Long articleId = id;

        try {
            Optional<Article> optionalArticle = articleRepository.findById(articleId);

            if(optionalArticle.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_POST);
            }

            Article article = optionalArticle.get();
            data = new ArticleResponseDto(article);

        }catch(Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 작성자가 수정을 위해 보는 조회페이지
    @Override
    public ResponseDto<ArticleResponseDto> getEditableArticle(Long authorId, Long id) {
        ArticleResponseDto data = null;
        Long articleId = id;

        try {
            // Optional<Article> optionalArticle = articleRepository.findByIdAndAuthorId(authorId, articleId);

            // if(optionalArticle.isEmpty()) {
            //    return ResponseDto.setFailed(ResponseMessage.NO_PERMISSION);
            // }

            // Article article = optionalArticle.get();
            // data = new ArticleResponseDto(article);

            Optional<Article> optionalArticle = articleRepository.findById(articleId);

            if(optionalArticle.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_POST);
            }

            Article article = optionalArticle.get();

            if(!article.getAuthorId().equals(authorId)) {
                return ResponseDto.setFailed(ResponseMessage.NO_PERMISSION);
            }

            data = new ArticleResponseDto(article);

        } catch(Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
}
