package com.example.basic.domain.entity;

import com.example.basic.type.MemberType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString // Entity에서는 @Data를 사용하기 보다는 직접 골라서 작성하는 것이 좋다.
@Table(name = "TBL_MEMBER")// 테이블명 작성
public class Member {
    @Id @GeneratedValue // @Id는 PK로 설정할 필드 위에 작성하고, ORACLE에서 SEQ 자동 증가는 @GeneratedValue를 사용한다.
    private Long id;
    @NotNull // JAVA에서의 Validation(DB와 상관 없음)
    private String memberName;
    @Column(unique = true, nullable = false) // DBMS에서의 NOT NULL 제약조건 추가(JAVA와 상관 없음)
    private String memberEmail;
    private String memberPassword;
    private int memberAge;
    @Enumerated(EnumType.STRING) // ENUM타입으로 필드를 선언하면, 기본 방식이 ORDINAL이므로 STRING으로 항상 직접 바꿔줘야 한다.
    private MemberType memberType;
}
