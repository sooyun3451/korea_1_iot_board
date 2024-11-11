package com.koreait.board_back.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_inclement
    private Long id;

    @JoinColumn(name = "article_id", nullable = false) // 외래 키(Foreign Key)를 명시적으로 정의하는 데 사용, (name = "article_id): 외래 키 컬럼이 article_id, null X
    @ManyToOne(fetch = FetchType.LAZY) // @ManyToOne: 이 엔티티가 다른 엔티티와 다대일(Many-to-One) 관계 (fetch = FetchType.LAZY): 지연 로딩(Lazy Loading)을 의미
    private Article article;

    @Column(nullable = false, name = "commenter_id")
    private Long commenterId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
}
