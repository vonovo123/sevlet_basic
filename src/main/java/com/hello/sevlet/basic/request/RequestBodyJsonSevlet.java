package com.hello.sevlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hello.sevlet.basic.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

@WebServlet(name = "requestBodyJsonService", urlPatterns = "/request-json")
public class RequestBodyJsonSevlet extends HttpServlet {

    private ObjectMapper objMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);
        User user = objMapper.readValue(messageBody, User.class);
        System.out.println("user = " + user.getUsername());
    }
}
