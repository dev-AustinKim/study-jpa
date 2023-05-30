package com.oauth.naver.service;


import com.oauth.naver.domain.MemberDTO;
import com.oauth.naver.entity.Member;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MemberService extends UserDetailsService {
//    회원가입
    public void join(MemberDTO memberDTO, PasswordEncoder passwordEncoder);

//    default Member toMemberEntity(MemberDTO memberDTO){
//        return Member.builder().id(memberDTO.getId())
//                .memberBirth(memberDTO.getMemberBirth())
//                .memberEmail(memberDTO.getMemberEmail())
//                .memberId(memberDTO.getMemberId())
//                .memberName(memberDTO.getMemberName())
//                .memberPassword(memberDTO.getMemberPassword())
//                .memberPhoneNumber(memberDTO.getMemberPhoneNumber())
//                .memberRole(memberDTO.getMemberRole())
//                .build();
//    }
}
