package org.example.mvc.view;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    // Field add => view, model
    private Object view;
    private Map<String, Object> model = new HashMap<>();
    // ModelAndView Constructor => viewName
    public ModelAndView(String viewName) {
        view = viewName;
    }

    // getModel method => model
    public Map<String, ?> getModel() {
        return Collections.unmodifiableMap(model);
    }

    // getViewName method => view
    public String getViewName() {
        return (this.view instanceof String ? (String) this.view : null);
    }
}
