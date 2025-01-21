package com.studymate.back.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 로그인 요청 데이터를 캡슐화하는 DTO 클래스
 * 클라이언트로부터 입력받은 데이터를 검증하고 전달
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    /**
     * 아이디
     * Not Null
     * 5 ~ 50자
     */
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Size(min = 5, max = 50, message = "아이디는 5자 이상, 50자 이하로 입력해야 합니다.")
    private String username;

    /**
     * 비밀번호
     * Not Null
     * 8 ~ 255자
     */
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 8, max = 255, message = "비밀번호는 8자 이상, 255자 이하로 입력해야 합니다.")
    private String password;
}
