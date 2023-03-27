package org.example.mvc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 모든 곳에 Filter 되도록 적용하겠다는 의미
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    // Field add => DEFAULT_ENCODING
    private final String DEFAULT_ENCODING = "UTF-8";
    // init method
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    // odFilter method
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        // 한글 안깨지게 하는 것
        req.setCharacterEncoding(DEFAULT_ENCODING);
        res.setCharacterEncoding(DEFAULT_ENCODING);

        chain.doFilter(req, res);
    }

    // destroy method
    @Override
    public void destroy() {
    }
}
