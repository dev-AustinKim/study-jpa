package com.oauth.naver.service;

import com.oauth.naver.domain.MemberDTO;
import com.oauth.naver.entity.Member;
import com.oauth.naver.provider.UserDetail;
import com.oauth.naver.repository.MemberRepository;
import com.oauth.naver.type.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
//        memberRepository.save(toMemberEntity(memberDTO));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        화면에서 입력한 회원 아이디를 통해 조회된 정보 (로그인 검사에 사용된다).
        Member member = memberRepository.findByMemberId(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
        return UserDetail.builder()
                .id(member.getId())
                .memberId(member.getMemberId())
                .memberPassword(member.getMemberPassword())
                .memberRole(member.getMemberRole())
                .build();
    }
}










