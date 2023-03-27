package org.example.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JspView implements View {
    // Field add => name
    private final String name;

    // JspView Constructor => name
    public JspView(String name) {
        this.name = name;
    }

    // render Constructor
    @Override
    public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse res) throws Exception {
        model.forEach(req::setAttribute);
        // RequestDispatcher => name
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(name);
        requestDispatcher.forward(req, res);
    }
}
