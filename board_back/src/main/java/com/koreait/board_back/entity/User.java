package com.koreait.board_back.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder(toBuilder = true)
// @Builder: 클래스 수준에 추가되는 어노테이션, 객체 생성 시 빌더 패턴 사용 가능
// (toBuilder = true) 옵션
// : 이미 생성된 객체에서 빌더를 사용할 수 있도록 설정
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_inclement
    private Long id;

    @Column(nullable = false, unique = true) // null X, uniqueKey
    private String userId;

    @Column(nullable = false) // null X
    private String password;

    @Column(nullable = false, unique = true) // null X, uniqueKey
    private String email;

    @Column(nullable = false) // null X
    private String name;

    @Column(nullable = false) // null X
    private String phone;

    @Column(columnDefinition = "ENUM('M', 'F')") // DB 컬럼 정보를 직접 줄 수 있음
    private String gender;
}
