package org.example.mvc.controller;

import org.example.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserListController implements Controller {
    // Field add => urlPath, users
    private final String USER_LIST = "/user/list";
    private final String USERS = "users";
    // handleRequest Constructor
    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute(USERS, UserRepository.findAll());
        return USER_LIST;
    }
}
