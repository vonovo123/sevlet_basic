package com.hello.sevlet.web.frontcontroller2.handler;

import com.hello.sevlet.web.frontcontroller2.ControllerV1;
import com.hello.sevlet.web.frontcontroller2.ControllerV2;
import com.hello.sevlet.web.frontcontroller2.ModelView;
import com.hello.sevlet.web.frontcontroller2.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ContollerV2HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean support(Object handler) {
        return handler instanceof ControllerV2;
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV2 controller = (ControllerV2) handler;
        Map<String, String> paramMap = getParamMap(request);
        Map<String,Object> model = new HashMap<>();
        String viewName = controller.process(paramMap,model);
        ModelView modelView = new ModelView(viewName);
        modelView.setModel(model);
        return modelView;
    }

    private Map<String,String> getParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName ->paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
