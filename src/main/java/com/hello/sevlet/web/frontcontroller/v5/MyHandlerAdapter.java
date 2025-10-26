package com.hello.sevlet.web.frontcontroller.v5;

import com.hello.sevlet.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface MyHandlerAdapter {
    boolean support(Object handler);
    ModelView handle(HttpServletRequest reqeust, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
