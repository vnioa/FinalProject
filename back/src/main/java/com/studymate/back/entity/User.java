package com.studymate.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 사용자 정보를 저장하는 Entity Class
 * users 테이블과 매핑
 */
@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@Setter
public class User {

    /**
     * 사용자 고유 ID -> 회원번호
     * Primary Key
     * Auto Increment
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 아이디
     * 고유값 -> 회원가입 시 중복확인
     * Not Null
     */
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    /**
     * 암호화된 비밀번호
     * Not Null
     */
    @Column(nullable = false, length = 255)
    private String password;

    /**
     * 사용자 이름
     * Not Null
     */
    @Column(nullable = false, length = 100)
    private String name;

    /**
     * 전화번호
     * Not Null
     */
    @Column(nullable = false, length = 15)
    private String phone;

    /**
     * 이메일
     * Unique
     * Not Null
     */
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    /**
     * 이메일 인증 여부
     * Not Null
     * Default: false
     */
    @Column(nullable = false)
    private Boolean emailVerified = false;

    /**
     * 생성 시간
     * Default: 현재 시간
     */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 마지막 수정 시간
     * Default: 현재 시간
     * 수정 시 자동 갱신
     */
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    /**
     * 업데이트 시 updatedAt 필드 갱신
     */
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
