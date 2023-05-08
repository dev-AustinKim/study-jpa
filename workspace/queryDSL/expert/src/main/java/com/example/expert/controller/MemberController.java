package com.example.expert.controller;

import com.example.expert.entity.pay.PayDTO;
import com.example.expert.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

//    결제 내역
    @GetMapping("pay/list")
    public List<PayDTO> getPayList(HttpSession session){
//        return memberService.getPays((Long)session.getAttribute("memberId"));
        return memberService.getPays(6L);
    }
}












