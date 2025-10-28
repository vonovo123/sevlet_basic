package com.hello.sevlet.web.frontcontroller2;

import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public interface ControllerV1 {
    ModelView process(Map<String,String> paramMap) throws ServletException, IOException;
}
