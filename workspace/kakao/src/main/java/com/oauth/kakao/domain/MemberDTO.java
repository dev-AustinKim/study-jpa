package com.oauth.kakao.domain;

import com.oauth.kakao.entity.Member;
import com.oauth.kakao.type.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
@NoArgsConstructor
public class MemberDTO implements Serializable {

    private Long id;
    private String memberName;
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDate memberBirth;
    private String memberPhoneNumber;
    private String memberId;
    private String memberPassword;
    private String memberEmail;
    private Role memberRole;

    public MemberDTO(Member member) {
        this.memberName = member.getMemberName();
        this.memberPhoneNumber = member.getMemberPhoneNumber();
        this.memberEmail = member.getMemberEmail();
    }
}















