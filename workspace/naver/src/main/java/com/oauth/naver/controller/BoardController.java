package com.oauth.naver.controller;

import com.oauth.naver.domain.MemberDTO;
import com.oauth.naver.provider.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board/*")
@Slf4j
public class BoardController {
    @GetMapping("/list")
    public void list(@AuthenticationPrincipal UserDetail userDetail, HttpSession session){
//        log.info("==============: " + userDetail.getMemberId());
        MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
        log.info("-----------------------------------------------");
        log.info(memberDTO.toString());
    }
}
