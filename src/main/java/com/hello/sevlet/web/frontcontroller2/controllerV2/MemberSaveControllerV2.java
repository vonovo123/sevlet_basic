package com.hello.sevlet.web.frontcontroller2.controllerV2;

import com.hello.sevlet.domain.member.Member;
import com.hello.sevlet.domain.member.MemberRepository;
import com.hello.sevlet.web.frontcontroller2.ControllerV1;
import com.hello.sevlet.web.frontcontroller2.ControllerV2;
import com.hello.sevlet.web.frontcontroller2.ModelView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV2 implements ControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String,String> paramMap, Map<String, Object> model) throws ServletException, IOException {
        Member newMember = new Member(paramMap.get("username"),Integer.parseInt(paramMap.get("age")));
        memberRepository.save(newMember);
        model.put("member", newMember);
        return "save-result";

    }
}
