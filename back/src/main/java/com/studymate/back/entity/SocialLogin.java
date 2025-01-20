package com.studymate.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 소셜 로그인 정보를 저장하는 Entity Class
 * social_logins 테이블과 매핑
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "social_logins")
public class SocialLogin {

    /**
     * 소셜 로그인 고유 ID
     * Primary Key
     * Auto Increment
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 사용자 ID
     * Foreign Key
     * users 테이블 id 필드 참조
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * 소셜 로그인 플랫폼
     * Google, Naver, Kakao, Github
     */
    @Column(nullable = false, length = 50)
    private String platform;

    /**
     * 플랫폼 고유 사용자 ID
     */
    @Column(nullable = false, length = 100)
    private String platformUserId;

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
