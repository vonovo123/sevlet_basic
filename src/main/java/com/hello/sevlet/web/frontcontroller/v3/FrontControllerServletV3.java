package com.hello.sevlet.web.frontcontroller.v3;

import com.hello.sevlet.web.frontcontroller.ModelView;
import com.hello.sevlet.web.frontcontroller.MyView;
import com.hello.sevlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.hello.sevlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.hello.sevlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
    private HashMap<String, ControllerV3> controllerMap =  new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV3 controller = controllerMap.get(requestURI);
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Map<String,String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);
        String viewName = mv.getViewName();
        viewResolver(viewName).render(mv.getModel(),request,response);

    }
    private MyView viewResolver(String viewName){
        return new MyView("/WEB-INF/views/"+viewName+".jsp");
    }

    private Map<String,String> createParamMap(HttpServletRequest request) throws ServletException, IOException {
        Map<String,String> paramMap = new HashMap<String,String>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
