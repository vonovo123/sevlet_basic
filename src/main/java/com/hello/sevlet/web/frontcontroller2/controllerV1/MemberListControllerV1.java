package com.hello.sevlet.web.frontcontroller2.controllerV1;

import com.hello.sevlet.domain.member.Member;
import com.hello.sevlet.domain.member.MemberRepository;
import com.hello.sevlet.web.frontcontroller2.ControllerV1;
import com.hello.sevlet.web.frontcontroller2.ModelView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MemberListControllerV1 implements ControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String,String> paramMap) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", members);
        return modelView;

    }
}
