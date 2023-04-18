package com.example.intermediate.entity.file;

import com.example.intermediate.audit.Period;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

//    JOINED(조인 전략)
//    부모 엔티티의 PK를 슈퍼키로 설정하고, 자식 엔티티의 PK를 서브키로 설정하는 전략.
//    정규화 방식
//    조회 시 JOIN으로 인해 성능 저하가 발생한다.
//    복잡한 쿼리 작성 필요
//    INSERT 작성 시 쿼리 2번 실행
@Entity
@Getter @Setter @ToString
@Table(name = "TBL_FILE")
@Inheritance(strategy = InheritanceType.JOINED)
public class File extends Period {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String uuid;
    private String filePath;
    private Long fileSize;
}
