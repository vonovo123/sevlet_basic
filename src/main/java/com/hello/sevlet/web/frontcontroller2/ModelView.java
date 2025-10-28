package com.hello.sevlet.web.frontcontroller2;

import java.util.HashMap;
import java.util.Map;

public class ModelView {
    private String viewPath;
    private Map<String,Object> model = new HashMap<String,Object>();

    public ModelView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public String getViewPath() {
        return viewPath;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
