package com.example.intermediate.entity.file;

import com.example.intermediate.type.RepresentationalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString(callSuper = true)
@Table(name = "TBL_MEMBER_FILE")
@PrimaryKeyJoinColumn(name = "MEMBER_ID")
public class MemberFile extends File {
//    대표 이미지 검사
    @Enumerated(EnumType.STRING)
    private RepresentationalType representationalType;
}
