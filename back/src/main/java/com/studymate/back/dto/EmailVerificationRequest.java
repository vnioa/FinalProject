package com.studymate.back.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 이메일 인증 요청 데이터를 캡슐화하는 DTO 클래스
 * 이메일과 인증 코드를 검증하고 전달
 */
@Getter
@Setter
@NoArgsConstructor
public class EmailVerificationRequest {

    /**
     * 이메일 주소
     * Not Null
     * 유효한 이메일 형식이어야 함
     */
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "유효한 이메일 형식이 아닙니다.")
    private String email;

    /**
     * 인증 코드
     * Not Null
     * 최대 10자
     */
    @NotBlank(message = "인증 코드는 필수 입력 값입니다.")
    private String code;
}
