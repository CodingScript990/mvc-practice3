package org.example.mvc.controller;

import org.example.mvc.model.User;
import org.example.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCreateController implements Controller {
    // Field add => Redirect url
    private final String REDIRECT_PATH = "redirect:/users";
    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // user add => userid, name
        UserRepository.save(new User(req.getParameter("userId"), req.getParameter("name")));
        return REDIRECT_PATH;
    }
}
