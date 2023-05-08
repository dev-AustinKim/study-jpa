package com.example.expert.service.order;

import com.example.expert.entity.member.Member;
import com.example.expert.entity.member.MemberDTO;
import com.example.expert.entity.order.Order;
import com.example.expert.entity.order.OrderDTO;

import java.util.Optional;

public interface OrderService {
//    주문자 정보
    public OrderDTO getOrdersWithMember(Long id);

    default OrderDTO toOrderDTO(Order order){
        return OrderDTO.builder().id(order.getId())
                .address(order.getAddress())
                .memberDTO(toMemberDTO(order.getMember()))
                .build();
    }

    default MemberDTO toMemberDTO(Member member){
        return MemberDTO.builder().id(member.getId())
                .memberName(member.getMemberName())
                .memberAge(member.getMemberAge())
                .memberPassword(member.getMemberPassword())
                .memberId(member.getMemberId())
                .address(member.getAddress())
                .build();
    }

}
