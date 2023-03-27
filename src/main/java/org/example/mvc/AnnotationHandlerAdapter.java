package org.example.mvc;

import org.example.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnnotationHandlerAdapter implements HandlerAdapter {
    // supports method => handler
    @Override
    public boolean supports(Object handler) {
        return handler instanceof AnnotationHandler;
    }

    // ModelAndView method => handle
    @Override
    public ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        // viewName => AnnotationHandler => handler => handle
        String viewName = ((AnnotationHandler) handler).handle(req, res);
        // ModelAndView => viewName
        return new ModelAndView(viewName);
    }
}
