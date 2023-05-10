package com.app.security.repository;

import com.app.security.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static com.app.security.entity.QMember.member;

@RequiredArgsConstructor
@Slf4j
public class MemberQueryDSLImpl implements MemberQueryDSL {
}
