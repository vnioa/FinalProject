package com.studymate.back.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 사용자 정보를 반환하는 DTO 클래스
 * 서버에서 처리된 사용자 데이터를 클라이언트로 전달
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    /**
     * 사용자 고유 ID
     */
    private Integer id;

    /**
     * 아이디
     */
    private String username;

    /**
     * 이름
     */
    private String name;

    /**
     * 전화번호
     */
    private String phone;

    /**
     * 이메일
     */
    private String email;

    /**
     * 이메일 인증 여부
     */
    private Boolean emailVerified;
}
