package com.koreait.board_back.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articles")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_inclement
    private Long id;

    @Column(nullable = false) // null X
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT") // null X, DB Type >> TEXT
    private String content;

    @Column(nullable = false, name = "author_id") // null X, DB >> author_id
    private Long authorId;

    @Builder.Default // Article 만들어질 때 댓글이 담길 공간(list)만들어 두기(@Builder.Default(는) Lombok(에서) 제공하며 빌더 패턴으로 객체 생성 시 필드의 기본값을 유지시켜 줌.)
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    // mappedBy = "article": Comment 엔티티 내에서 article 필드를 통해 관계가 매핑되었음을 명시
    // cascade = Cascade.Type.ALL: 부모 엔티티(Article)의 변경 사항이 자식 엔티티(Comment)에도 전파된다는 것을 의미
    // orphanRemoval = true: 부모 엔티티에서 자식 엔티티와의 연관 관계가 제거될 때, 해당 자식 엔티티가 데이터베이스에서도 자동으로 삭제
    private List<Comment> comments = new ArrayList<>();
}
