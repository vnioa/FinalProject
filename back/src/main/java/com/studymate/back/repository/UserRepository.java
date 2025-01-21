package com.studymate.back.repository;

import com.studymate.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * users 테이블과 상호작용하는 JPA Repository 인터페이스
 * Spring Data JPA가 제공하는 기본 CRUD 메서드 상속받음
 * 사용자 관련 커스텀 쿼리 메서드 정의
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 아이디로 사용자 검색
     * @param username 아이디
     * @return 해당 아이디를 가진 User 객체 (Optional)
     */
    Optional<User> findByUsername(String username);

    /**
     * 이메일 인증된 사용자 검색
     * @param email 이메일 주소
     * @return 해당 이메일을 가진 User 객체 (Optional)
     */
    Optional<User> findByEmail(String email);

    /**
     * 이메일 인증된 사용자 검색
     * @param email 이메일 주소
     * @param emailVerified 이메일 인증 여부
     * @return 인증된 이메일을 가진 User 객체 (Optional)
     */
    Optional<User> findByEmailAndEmailVerified(String email, Boolean emailVerified);

    /**
     * 아이디 중복 확인
     * @param username 아이디
     * @return 중복된 아이디가 존재하면 true, 존재하지 않으면 false
     */
    boolean existsByUsername(String username);

    /**
     * 이메일 중복 확인
     * @param email 이메일 주소
     * @return 중복된 이메일이 존재하면 true, 존재하지 않으면 false
     */
    boolean existsByEmail(String email);
}
