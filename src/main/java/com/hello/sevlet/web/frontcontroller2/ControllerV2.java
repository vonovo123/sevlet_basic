package com.hello.sevlet.web.frontcontroller2;

import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

/**
 * @param paramMap
 * @param model
 * @return viewName
 */
public interface ControllerV2 {
    String process(Map<String,String> paramMap,Map<String,Object> model) throws ServletException, IOException;
}
