package com.app.security.service;


import com.app.security.domain.MemberDTO;
import com.app.security.entity.Member;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public interface MemberService extends UserDetailsService {
//    회원가입
    public void join(MemberDTO memberDTO, PasswordEncoder passwordEncoder);

    default Member toMemberEntity(MemberDTO memberDTO){
        return Member.builder().id(memberDTO.getId())
                .memberBirth(memberDTO.getMemberBirth())
                .memberEmail(memberDTO.getMemberEmail())
                .memberId(memberDTO.getMemberId())
                .memberName(memberDTO.getMemberName())
                .memberPassword(memberDTO.getMemberPassword())
                .memberPhoneNumber(memberDTO.getMemberPhoneNumber())
                .memberRole(memberDTO.getMemberRole())
                .build();
    }
}
