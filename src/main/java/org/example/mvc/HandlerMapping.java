package org.example.mvc;

public interface HandlerMapping {
    // Controller => HandlerKey
    Object findHandler(HandlerKey handlerKey);
}
