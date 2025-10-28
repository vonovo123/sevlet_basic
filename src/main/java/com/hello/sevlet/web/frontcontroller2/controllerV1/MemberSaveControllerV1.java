package com.hello.sevlet.web.frontcontroller2.controllerV1;

import com.hello.sevlet.domain.member.Member;
import com.hello.sevlet.domain.member.MemberRepository;
import com.hello.sevlet.web.frontcontroller2.ControllerV1;
import com.hello.sevlet.web.frontcontroller2.ModelView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV1 implements ControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String,String> paramMap) throws ServletException, IOException {
        Member newMember = new Member(paramMap.get("username"),Integer.parseInt(paramMap.get("age")));
        memberRepository.save(newMember);
        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", newMember);
        return modelView;

    }
}
