package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.RequestMethod;
import org.example.mvc.view.JspViewResolver;
import org.example.mvc.view.ModelAndView;
import org.example.mvc.view.View;
import org.example.mvc.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    // logger add
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    // RequestMappingHandlerMapping add
    private List<HandlerMapping> handlerMappings;
    // List type HandlerAdapter add
    private List<HandlerAdapter> handlerAdapters;
    // List type ViewResolver add
    private List<ViewResolver> viewResolvers;

    // init Constructor => req, res
    @Override
    public void init() throws ServletException {
        // HomeController => home.jsp
        RequestMappingHandlerMapping rmm = new RequestMappingHandlerMapping();
        // HomeController add
        rmm.init();

        // AnnotationHandlerMapping Constructor add
        AnnotationHandlerMapping ahm = new AnnotationHandlerMapping("org.example");
        // AnnotationHandlerMapping initialize
        ahm.initialize();

        // HandlerMapping => RequestMappingHandlerMapping, AnnotationHandlerMapping
        handlerMappings = List.of(rmm, ahm);

        // SimpleControllerHandlerAdapter, AnnotationHandlerAdapter add
        handlerAdapters = List.of(new SimpleControllerHandlerAdapter(), new AnnotationHandlerAdapter());

        // JspViewResolver => .jsp
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    // Service Constructor => req, res
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started.");
        // reqURI
        String reqURI = req.getRequestURI();
        // reqMethod
        RequestMethod reqMethod = RequestMethod.valueOf(req.getMethod());
        try {
            // AnnotationHandler => handlerMappings
            Object handler = handlerMappings.stream()
                    .filter(hm -> hm.findHandler(new HandlerKey(reqMethod, reqURI)) != null)
                    .map(hm -> hm.findHandler(new HandlerKey(reqMethod, reqURI)))
                    .findFirst()
                    .orElseThrow(() -> new ServletException("No handler for [" + reqMethod + ", " + reqURI + "]"));

            // handlerAdapters => handler
            HandlerAdapter handlerAdapter = handlerAdapters.stream()
                    .filter(ha -> ha.supports(handler))
                    .findFirst()
                    .orElseThrow(() -> new ServletException("No adapter for handler [" + handler + "]"));

            // ModelAndView => handlerAdapter
            ModelAndView modelAndView = handlerAdapter.handle(req, res, handler);

            // ViewResolver
            for (ViewResolver viewResolver : viewResolvers) {
                // View => viewName
                View view = viewResolver.resolveView(modelAndView.getViewName());
                view.render(modelAndView.getModel(), req, res);
            }
        } catch (Exception e) {
            log.error("exception occurred: [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }
    }
}
