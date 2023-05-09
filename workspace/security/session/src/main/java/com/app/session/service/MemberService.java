package com.app.session.service;

import com.app.session.domain.MemberDTO;
import com.app.session.entity.Member;

import java.util.Optional;

public interface MemberService {
//    회원가입
    public void join(MemberDTO memberDTO);

//    로그인
    public Optional<Member> login(String memberId, String memberPassword);


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
