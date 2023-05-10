package com.app.security.entity;

import com.app.security.audit.Period;
import com.app.security.type.Role;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TBL_MEMBER")
public class Member extends Period {
    @Id @GeneratedValue
    private Long id;
    @NotNull
    private String memberName;
    @NotNull private LocalDate memberBirth;
    @Column(unique = true)
    @NotNull private String memberPhoneNumber;
    @Column(unique = true)
    @NotNull private String memberId;
    @NotNull private String memberPassword;
    @Column(unique = true)
    @NotNull private String memberEmail;
    @Enumerated(EnumType.STRING)
    @NotNull private Role memberRole;

    @Builder
    public Member(Long id, String memberName, LocalDate memberBirth, String memberPhoneNumber, String memberId, String memberPassword, String memberEmail, Role memberRole) {
        this.id = id;
        this.memberName = memberName;
        this.memberBirth = memberBirth;
        this.memberPhoneNumber = memberPhoneNumber;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
        this.memberRole = memberRole;
    }
}




























