package com.example.expert.service.member;

import com.example.expert.entity.member.Member;
import com.example.expert.entity.pay.Pay;
import com.example.expert.entity.pay.PayDTO;
import com.example.expert.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("member") @Primary
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public List<PayDTO> getPays(Long id) {
        Optional<Member> member = memberRepository.findPaysById_QueryDSL(id);
        List<PayDTO> payDTOS = new ArrayList<>();
        member.get().getPays().forEach(pay -> payDTOS.add(toPayDTO(pay)));
        return payDTOS;
    }
}
