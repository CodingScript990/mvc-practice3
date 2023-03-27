package org.example.mvc;

import org.example.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandlerAdapter {
    // support Object
    boolean supports(Object handler);

    // ModelAndView handle
    ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception;
}
