package com.hello.sevlet.web.frontcontroller.v1.controller;

import com.hello.sevlet.domain.member.Member;
import com.hello.sevlet.domain.member.MemberRepository;
import com.hello.sevlet.web.frontcontroller.MyView;
import com.hello.sevlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member member = new Member(username,age);
        memberRepository.save(member);
        //Model에 데이터를 보관
        request.setAttribute("member",member);
        String viewPath = "/WEB-INF/views/save-result.jsp";
    }
}
