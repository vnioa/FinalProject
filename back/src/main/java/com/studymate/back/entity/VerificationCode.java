package com.studymate.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 인증 코드를 저장하는 Entity Class
 * verification_codes 테이블과 매핑
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "verification_codes")
public class VerificationCode {

    /**
     * 인증 코드 고유 ID
     * Primary Key
     * Auto Increment
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 사용자 ID
     * Foreign Key
     * users 테이블의 ID 참조
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * 인증에 사용된 이메일
     */
    @Column(nullable = false, length = 100)
    private String email;

    /**
     * 인증 코드
     * 최대 10자
     */
    @Column(nullable = false, length = 10)
    private String code;

    /**
     * 인증 코드 만료 시간
     */
    @Column(nullable = false)
    private LocalDateTime expiresAt;

    /**
     * 생성 시간
     * Default: 현재 시간
     */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
