package org.example.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RedirectView implements View {
    // Field add => name, DEFAULT_REDIRECT_PREFIX
    private final String name;
    public static final String DEFAULT_REDIRECT_PREFIX = "redirect:";

    // RedirectView Constructor => name
    public RedirectView(String name) {
        this.name = name;
    }

    // render Constructor
    @Override
    public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.sendRedirect(name.substring(DEFAULT_REDIRECT_PREFIX.length()));
    }
}
