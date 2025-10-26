package com.hello.sevlet.web.frontcontroller.v2.controller;

import com.hello.sevlet.web.frontcontroller.MyView;
import com.hello.sevlet.web.frontcontroller.v1.ControllerV1;
import com.hello.sevlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        return new MyView(viewPath);
    }
}
