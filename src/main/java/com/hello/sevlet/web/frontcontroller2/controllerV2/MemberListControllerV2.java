package com.hello.sevlet.web.frontcontroller2.controllerV2;

import com.hello.sevlet.domain.member.Member;
import com.hello.sevlet.domain.member.MemberRepository;
import com.hello.sevlet.web.frontcontroller2.ControllerV1;
import com.hello.sevlet.web.frontcontroller2.ControllerV2;
import com.hello.sevlet.web.frontcontroller2.ModelView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MemberListControllerV2 implements ControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String,String> paramMap, Map<String, Object> model) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);
        return "members";

    }
}
