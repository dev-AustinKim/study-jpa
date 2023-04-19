package com.example.advanced.entity.member;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_FILE")
public class File {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String fileName;
    @NotNull private String filePath;
    @NotNull private String fileUuid;
    @NotNull private Long fileSize;

//    1:1 관계에서는 추후 유지보수시 N이 될 수 있는 객체를 연관관계의 주인으로 설정한다.
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}



















