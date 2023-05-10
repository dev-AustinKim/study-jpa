package com.app.security.repository;

import com.app.security.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberQueryDSL {
//    아이디로 전체 정보 조회 (MemberDetailService)
    public Optional<Member> findByMemberId(String memberId);
}
