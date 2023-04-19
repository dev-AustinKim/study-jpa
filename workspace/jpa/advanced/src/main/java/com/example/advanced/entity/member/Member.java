package com.example.advanced.entity.member;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_MEMBER")
public class Member {
    @Id @GeneratedValue
    private Long id;
    @NotNull @Column(unique = true)
    private String memberId;
    @NotNull private String memberPassword;
    @NotNull @Column(unique = true)
    private String memberEmail;
    @Embedded private MemberAddress memberAddress;
}

















