package com.studymate.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 이메일 인증 코드를 저장하는 Entity 클래스
 * verification_codes 테이블에 매핑
 * 인증 코드 발급 및 검증 관리
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "verification_codes")
public class VerificationCode {

    /**
     * 인증 코드 고유 ID
     * Primary Key
     * 참조 타입 Integer로 설정하여 NULL 처리 가능하나 처리 X
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 이메일 주소
     * Not Null
     * 최대 100자
     */
    @Column(nullable = false, length = 100)
    private String email;

    /**
     * 인증 코드
     * Not Null
     * 최대 10자
     */
    @Column(nullable = false, length = 10)
    private String code;

    /**
     * 인증 코드 만료 시간
     * 참조 타입 LocalDateTime 사용
     */
    @Column(nullable = false)
    private LocalDateTime expiresAt;

    /**
     * 인증 코드 생성 시간
     * 참조 타입 LocalDateTime 사용
     */
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    /**
     * 데이터 저장 전 실행되는 콜백 메서드
     * 생성 시간을 현재 시간으로 설정
     */
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
