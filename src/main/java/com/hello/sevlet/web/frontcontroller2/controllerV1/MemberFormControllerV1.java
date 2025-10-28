package com.hello.sevlet.web.frontcontroller2.controllerV1;

import com.hello.sevlet.web.frontcontroller2.ControllerV1;
import com.hello.sevlet.web.frontcontroller2.ModelView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV1 implements ControllerV1 {
    @Override
    public ModelView process(Map<String,String> paramMap) throws ServletException, IOException {
        return new ModelView("new-form");
    }
}
