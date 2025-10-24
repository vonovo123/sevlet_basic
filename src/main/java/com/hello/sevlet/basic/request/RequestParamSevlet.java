package com.hello.sevlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 1.파라미터 전송기능
 * http://localhost:8080/request-param?username=hello&age=20&username=bye&age=30
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamSevlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회 ] - start");
        Enumeration<String> parameterNames = req.getParameterNames();
        parameterNames.asIterator().forEachRemaining(paramName -> {
            System.out.println(paramName + ":" + req.getParameter(paramName));
        });
        System.out.println("[전체 파라미터 조회 ] - end");
        System.out.println();
        System.out.println("[단위 파라미터 조회 ] - start");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("age = " + age);
        System.out.println("username = " + username);
        System.out.println("[단위 파라미터 조회 ] - end");
        System.out.println();
        System.out.println("[이름이 같은 복수 파라미터 조회 ] - start");
        String[] usernames = req.getParameterValues("username");
        for (String s : usernames) {
            System.out.println(s);
        }

        String[] ages = req.getParameterValues("age");
        for (String s : ages) {
            System.out.println(s);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회 ] - end");
        System.out.println();

        resp.getWriter().write("ok");
    }
}
