package com.hello.sevlet.web.frontcontroller2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MyView {
    private String viewPath;
    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(viewPath).forward(request,response);
    }

    public void render(Map <String,Object> modelView, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelView.forEach((k,v)->request.setAttribute(k,v));
        request.getRequestDispatcher(viewPath).forward(request,response);
    }


}
