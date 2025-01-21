package com.studymate.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 사용자 정보를 저장하는 Entity 클래스
 * users 테이블에 매핑
 * 사용자 계정 관련 정보 관리
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {

    /**
     * 사용자 고유 ID
     * Primary Key
     * 참조 타입으로 설정하여 NULL 처리 가능
     * 자동 증가를 위해 JPA가 NULL 값을 사용
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 아이디
     * Not Null
     * 중복 불가
     * 최대 50자
     */
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    /**
     * 암호화된 상태의 비밀번호
     * Not Null
     * 최대 255자
     */
    @Column(nullable = false, length = 255)
    private String password;

    /**
     * 이름
     * Not Null
     * 최대 100자
     */
    @Column(nullable = false, length = 100)
    private String name;

    /**
     * 전화번호
     * Not Null
     * 최대 15자
     */
    @Column(nullable = false, length = 15)
    private String phone;

    /**
     * 이메일 주소
     * Not Null
     * 중복 불가
     * 최대 100자
     */
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    /**
     * 이메일 인증 여부
     * 참조 타입 Boolean 사용하여 NULL 처리 가능 -> 기본적으로는 Not Null
     * Default: false
     */
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean emailVerified = false;

    /**
     * 계정 생성 시간
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
