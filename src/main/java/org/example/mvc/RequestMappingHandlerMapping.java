package org.example.mvc;

import org.example.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping implements HandlerMapping {
    // Field add => urlPath[/, /users[get,post], /user/form[get]]
    private final String ROOT = "/";
    private final String ROOT_USERS_GET = "/users";
    private final String ROOT_USERS_POST = "/users";
    private final String ROOT_USER_FORM = "/user/form";
    // Map type mappings => new HashMap
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    // init method
    void init() {
//        mappings.put(new HandlerKey(RequestMethod.GET, ROOT), new HomeController()); // root
        mappings.put(new HandlerKey(RequestMethod.GET, ROOT_USERS_GET), new UserListController()); // users[GET]
        mappings.put(new HandlerKey(RequestMethod.POST, ROOT_USERS_POST), new UserCreateController()); // users[POST]
        mappings.put(new HandlerKey(RequestMethod.GET, ROOT_USER_FORM), new ForwardController(ROOT_USER_FORM)); // user/form[GET]
    }

    // Controller type findHandler Constructor
    public Controller findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }
}
