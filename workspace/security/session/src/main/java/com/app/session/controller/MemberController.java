package com.app.session.controller;

import com.app.session.domain.MemberDTO;
import com.app.session.entity.Member;
import com.app.session.exception.LoginFailedException;
import com.app.session.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("join")
    public String goToJoinForm(MemberDTO memberDTO){
        return "/member/join";
    }

    @PostMapping("join")
    public RedirectView join(MemberDTO memberDTO){
        memberService.join(memberDTO);
        return new RedirectView("/member/login");
    }

    @GetMapping("login")
    public String goToLoginForm(){
        return "/member/login";
    }

    @PostMapping("login")
    public RedirectView login(String memberId, String memberPassword, HttpSession session){
        log.info("{}, {}", memberId, memberPassword);
        memberService.login(memberId, memberPassword).ifPresentOrElse(member -> {
            session.setAttribute("role", member.getMemberRole().name());
            session.setAttribute("memberId", member.getMemberId());
            session.setAttribute("id", member.getId());
            session.setMaxInactiveInterval(1800); //초 단위, 0 또는 -1일 경우 세션 무한 유지
        }, () -> {throw new LoginFailedException();});

        return new RedirectView("/board/list");
    }

    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
//        session.invalidate();
        session.removeAttribute("id");
        session.removeAttribute("memberId");
        session.removeAttribute("role");
        session.invalidate();
        return new RedirectView("/member/login");
    }
}
