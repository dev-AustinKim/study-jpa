package com.app.session.repository;

import com.app.session.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberQueryDSL {
}
