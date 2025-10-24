package com.hello.sevlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderService", urlPatterns = "/response-header")
public class ResponseHeaderSevlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //[status-line]
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        resp.setHeader("Content-Type", "text/charset=UTF-8");
        resp.setHeader("Cache-Control", "no-cache, no-store,  must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header","hello");
        PrintWriter out = resp.getWriter();
        redirect(resp);
        cookie(resp);
        out.write("ok");
    }
    private void cookie(HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("myCookie","hello");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);

    }

    private void redirect(HttpServletResponse resp) throws IOException {
        //resp.setStatus(resp.SC_FOUND);
        //resp.setHeader("Location", "/basic/hello-form.html");
        resp.sendRedirect("/basic/hello-form.html");
    }
}
