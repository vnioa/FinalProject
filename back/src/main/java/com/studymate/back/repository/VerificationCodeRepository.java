package com.studymate.back.repository;

import com.studymate.back.entity.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * verification_codes 테이블과 상호작용하는 JPA Repository 인터페이스
 * 이메일 인증 코드와 관련된 데이터 관리
 */
@Repository
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Integer> {

    /**
     * 특정 사용자(user_id)의 인증 코드 검색
     * @param userId 사용자 ID
     * @return 해당 사용자의 인증 코드 객체 (Optional)
     */
    Optional<VerificationCode> findByUserId(Integer userId);

    /**
     * 인증 코드와 이메일로 유효한 데이터 검색
     * @param email 이메일 주소
     * @param code 인증 코드
     * @param now 현재 시간 (만료 시간 비교를 위해 사용)
     * @return 유효한 인증 코드 객체 (Optional)
     */
    Optional<VerificationCode> findByEmailAndCodeAndExpiresAtAfter(String email, String code, LocalDateTime now);

    /**
     * 이메일로 인증 코드 검색
     * @param email 이메일 주소
     * @return 해당 이메일의 읹능 코드 객체 (Optional)
     */
    Optional<VerificationCode> findByEmail(String email);

    /**
     * 특정 인증 코드 삭제
     * @param code 인증 코드
     */
    void deleteByCode(String code);
}
