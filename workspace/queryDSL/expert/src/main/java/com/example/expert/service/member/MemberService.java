package com.example.expert.service.member;

import com.example.expert.entity.pay.Pay;
import com.example.expert.entity.pay.PayDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
//    결제 내역
    public List<PayDTO> getPays(Long id);

    default PayDTO toPayDTO(Pay pay){
        return PayDTO.builder().id(pay.getId())
                .totalPrice(pay.getTotalPrice())
                .payStatus(pay.getPayStatus())
                .build();
    }
}
