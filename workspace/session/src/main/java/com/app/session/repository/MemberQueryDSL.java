package com.app.session.repository;

import com.app.session.entity.Member;

import java.util.Optional;

public interface MemberQueryDSL {
//    로그인
    public Optional<Member> login(String memberId, String memberPassword);
}
