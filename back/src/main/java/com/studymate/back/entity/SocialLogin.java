package com.studymate.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 소셜 로그인 정보를 저장하는 Entity 클래스
 * social_logins 테이블에 매핑
 * 사용자와 소셜 계정 간 연관 관계 관리
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "social_logins")
public class SocialLogin {

    /**
     * 소셜 로그인 고유 ID
     * Primary Key
     * 참조 타입 Integer로 설정하여 NULL 처리 가능하나 NULL 사용 X
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 사용자와의 관계를 나타내는 Foreign Key
     * users 테이블과 연결
     * 1:N 관계 -> ManyToOne
     * Not Null
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * 소셜 로그인 플랫폼
     * Google, Naver, Kakao, Github
     * Not Null
     * 최대 50자
     */
    @Column(nullable = false, length = 50)
    private String platform;

    /**
     * 플랫폼 고유 사용자 ID
     * Not Null
     * 최대 100자
     */
    @Column(nullable = false, length = 100)
    private String platformUserId;

    /**
     * 소셜 로그인 데이터 생성 시간
     * 참조 타입 LocalDateTime 사용
     * 수정 불가
     */
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    /**
     * 마지막 수정 시간
     * 참조 타입 LocalDateTime 사용
     * 자동 업데이트
     */
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    /**
     * 데이터 저장 전 실행되는 콜백 메서드
     * 생성 시간과 수정 시간을 현재 시간으로 설정
     */
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 데이터 업데이트 전 실행되는 콜백 메서드
     * 수정 시간을 현재 시간으로 설정
     */
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
