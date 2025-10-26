package com.hello.sevlet.web.frontcontroller.v4.controller;

import com.hello.sevlet.domain.member.Member;
import com.hello.sevlet.domain.member.MemberRepository;
import com.hello.sevlet.web.frontcontroller.ModelView;
import com.hello.sevlet.web.frontcontroller.v4.ControllerV4;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = new Member(username,age);
        memberRepository.save(member);
        model.put("member", member);
        return "save-result";
    }
}
