package com.example.expert.entity.order;

import com.example.expert.entity.embeddable.Address;
import com.example.expert.entity.member.MemberDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class OrderDTO {
    private Long id;
    private Address address;
    private MemberDTO memberDTO;
}
