package org.example.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller {
    // Field add => forwardUriPath
    private final String forwardUriPath;

    // ForwardController Constructor
    public ForwardController(String forwardUriPath) {
        this.forwardUriPath = forwardUriPath;
    }

    // handleRequest Constructor
    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
        return forwardUriPath;
    }
}
