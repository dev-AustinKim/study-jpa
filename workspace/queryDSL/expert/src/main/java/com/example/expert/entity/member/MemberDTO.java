package com.example.expert.entity.member;

import com.example.expert.entity.embeddable.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
    private Long id;
    private String memberId;
    private String memberPassword;
    private String memberName;
    private Integer memberAge;
    private Address address;
}
