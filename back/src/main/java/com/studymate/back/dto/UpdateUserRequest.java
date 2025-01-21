package com.studymate.back.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 사용자 정보 업데이트 요청 데이터를 캡슐화하는 DTO 클래스
 * 클라이언트로부터 입력받은 데이터를 검증하고 전달
 */
@Getter
@Setter
@NoArgsConstructor
public class UpdateUserRequest {

    /**
     * 이름
     * 필수 입력 값
     * 2 ~ 100자
     */
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    @Size(min = 2, max = 100, message = "이름은 2자 이상, 100자 이하로 입력해야 합니다.")
    private String name;

    /**
     * 전화번호
     * 필수 입력 값
     * 숫자로만 구성
     * 최대 15자
     */
    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "전화번호는 10자 이상, 15자 이하의 숫자로 입력해야 합니다.")
    private String phone;

    /**
     * 이메일 주소
     * 필수 입력 값
     * 유효한 이메일 형식이어야 함
     */
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "유효한 이메일 형식이 아닙니다.")
    private String email;
}
