package com.example.basic.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {
    @GeneratedValue // 시퀀스를 해준다.
    @Id //pk를 뜻한다.
    private Long id; // pk
    private String memberName;
    @Column(unique = true)
    private String memberEmail;
    private String memberPassword;
    private int memberAge;
}
