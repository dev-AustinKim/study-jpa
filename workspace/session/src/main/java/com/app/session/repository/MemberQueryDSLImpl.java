package com.app.session.repository;

import com.app.session.entity.Member;
import com.app.session.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static com.app.session.entity.QMember.member;

@RequiredArgsConstructor
@Slf4j
public class MemberQueryDSLImpl implements MemberQueryDSL {
    private final JPAQueryFactory query;

    @Override
    public Optional<Member> login(String memberId, String memberPassword) {
        log.info("{}, {}", memberId, memberPassword);
        return Optional.ofNullable(
                query
                .select(member)
                .from(member)
                .where(member.memberId.eq(memberId)
                        .and(member.memberPassword.eq(memberPassword)))
                .fetchOne());
    }
}
