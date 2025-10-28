package com.hello.sevlet.web.frontcontroller2.controllerV2;

import com.hello.sevlet.web.frontcontroller2.ControllerV1;
import com.hello.sevlet.web.frontcontroller2.ControllerV2;
import com.hello.sevlet.web.frontcontroller2.ModelView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public String process(Map<String,String> paramMap, Map<String, Object> model) throws ServletException, IOException {
        return "new-form";
    }
}
