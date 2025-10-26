package com.hello.sevlet.web.frontcontroller.v4;

import com.hello.sevlet.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

/**
 * @param paramMap
 * @param model
 * @return viewName
 */
public interface ControllerV4 {
    String process(Map<String,String> paramMap,Map<String,Object> model) throws ServletException, IOException;
}
