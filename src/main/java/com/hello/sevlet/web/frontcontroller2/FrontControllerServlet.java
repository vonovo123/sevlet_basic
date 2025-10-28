package com.hello.sevlet.web.frontcontroller2;

import com.hello.sevlet.web.frontcontroller2.controllerV1.MemberFormControllerV1;
import com.hello.sevlet.web.frontcontroller2.controllerV1.MemberListControllerV1;
import com.hello.sevlet.web.frontcontroller2.controllerV1.MemberSaveControllerV1;
import com.hello.sevlet.web.frontcontroller2.controllerV2.MemberFormControllerV2;
import com.hello.sevlet.web.frontcontroller2.controllerV2.MemberListControllerV2;
import com.hello.sevlet.web.frontcontroller2.controllerV2.MemberSaveControllerV2;
import com.hello.sevlet.web.frontcontroller2.handler.ContollerV1HandlerAdapter;
import com.hello.sevlet.web.frontcontroller2.handler.ContollerV2HandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FrontController2Servlet", urlPatterns = "/front-controller2/*")
public class FrontControllerServlet extends HttpServlet {
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapterList = new ArrayList<>();

    private void initHandlerMappingMap(){
        handlerMappingMap.put("/front-controller2/v1/members/new-form", new MemberFormControllerV1());
        handlerMappingMap.put("/front-controller2/v1/members/save", new MemberSaveControllerV1());
        handlerMappingMap.put("/front-controller2/v1/members", new MemberListControllerV1());
        handlerMappingMap.put("/front-controller2/v2/members/new-form", new MemberFormControllerV2());
        handlerMappingMap.put("/front-controller2/v2/members/save", new MemberSaveControllerV2());
        handlerMappingMap.put("/front-controller2/v2/members", new MemberListControllerV2());
    }
    private void initHandlerAdapterList(){
        handlerAdapterList.add(new ContollerV1HandlerAdapter());
        handlerAdapterList.add(new ContollerV2HandlerAdapter());
    }

    public FrontControllerServlet() {
        initHandlerAdapterList();
        initHandlerMappingMap();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request);

        if(handler == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter handlerAdapter = getHandlerAdapter(handler);
        ModelView mv = handlerAdapter.handle(request,response,handler);
        String viewPath = mv.getViewPath();
        viewResolver(viewPath).render(mv.getModel(),request,response);
    }

    private Object getHandler(HttpServletRequest request) {
        Object handler;
        String requestURI = request.getRequestURI();
        handler = handlerMappingMap.get(requestURI);
        return handler;
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapterList) {
            if(adapter.support(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adpater not found handler= " + handler);
    }

    private MyView viewResolver(String viewName) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/"+viewName+".jsp");
    }
}
