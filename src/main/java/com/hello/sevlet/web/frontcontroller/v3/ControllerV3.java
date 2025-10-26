package com.hello.sevlet.web.frontcontroller.v3;

import com.hello.sevlet.web.frontcontroller.ModelView;
import com.hello.sevlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String,String> paramMap) throws ServletException, IOException;
}
