package com.app.security.service;

import com.app.security.domain.MemberDTO;
import com.app.security.entity.Member;
import com.app.security.provider.UserDetail;
import com.app.security.repository.MemberRepository;
import com.app.security.type.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("member") @Primary
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public void join(MemberDTO memberDTO, PasswordEncoder passwordEncoder) {
        memberDTO.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
        memberDTO.setMemberRole(Role.MEMBER);
        memberRepository.save(toMemberEntity(memberDTO));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberId(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
        return UserDetail.builder()
                .id(member.getId())
                .memberId(member.getMemberId())
                .memberPassword(member.getMemberPassword())
                .memberRole(member.getMemberRole())
                .build();
    }
}










