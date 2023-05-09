package com.app.session.service;

import com.app.session.domain.MemberDTO;
import com.app.session.entity.Member;
import com.app.session.exception.LoginFailedException;
import com.app.session.repository.MemberRepository;
import com.app.session.type.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("member") @Primary
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public void join(MemberDTO memberDTO) {
        memberDTO.setMemberRole(Role.MEMBER);
        memberRepository.save(toMemberEntity(memberDTO));
    }

    @Override
    public Optional<Member> login(String memberId, String memberPassword) {
        return memberRepository.login(memberId, memberPassword);
    }
}
