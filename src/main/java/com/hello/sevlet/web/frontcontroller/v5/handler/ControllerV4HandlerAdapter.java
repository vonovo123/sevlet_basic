package com.hello.sevlet.web.frontcontroller.v5.handler;

import com.hello.sevlet.web.frontcontroller.ModelView;
import com.hello.sevlet.web.frontcontroller.v3.ControllerV3;
import com.hello.sevlet.web.frontcontroller.v4.ControllerV4;
import com.hello.sevlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean support(Object handler) {
        return handler instanceof ControllerV4;
    }

    @Override
    public ModelView handle(HttpServletRequest reqeust, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4) handler;
        Map<String,String> paramMap =  createParamMap(reqeust);
        Map<String,Object> model = new HashMap<>();
        String viewName = controller.process(paramMap,model);
        ModelView modelView = new ModelView(viewName);
        modelView.setModel(model);
        return modelView;
    }

    private Map<String,String> createParamMap(HttpServletRequest request) throws ServletException, IOException {
        Map<String,String> paramMap = new HashMap<String,String>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
