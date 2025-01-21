package com.studymate.back.repository;

import com.studymate.back.entity.SocialLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * social_logins 테이블과 상호작용하는 JPA Repository 인터페이스
 * 사용자와 소셜 로그인 플랫폼 간의 데이터 관리
 */
@Repository
public interface SocialLoginRepository extends JpaRepository<SocialLogin, Integer> {

    /**
     * 특정 사용자(user_id)의 소셜 로그인 정보 검색
     * @param userId 사용자 ID
     * @return 해당 사용자의 소셜 로그인 정보 리스트
     */
    List<SocialLogin> findByUserId(Integer userId);

    /**
     * 플랫폼별 소셜 로그인 정보 검색
     * @param platform 소셜 로그인 플랫폼 (Google, Naver, Kakao, Github)
     * @param platformUserId 소셜 플랫폼에서 제공하는 고유 사용자 ID
     * @return 해당 플랫폼 및 사용자 ID에 매칭되는 SocialLogin 객체 (Optional)
     */
    Optional<SocialLogin> findByPlatformAndPlatformUserId(String platform, String platformUserId);

    /**
     * 특정 플랫폼과 사용자 ID의 소셜 로그인 존재 여부 확인
     * @param platform 소셜 로그인 플랫폼 (Google, Naver, Kakao, Github)
     * @param platformUserId 소셜 플랫폼의 고유 사용자 ID
     * @return 존재하면 true, 존재하지 않으면 false
     */
    boolean existsByPlatformAdnAndPlatformUserId(String platform, String platformUserId);
}
