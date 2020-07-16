package com.lele.boot.leleboothelloworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/home")
    public String home(){
        return "hello agan !";
    }

    @GetMapping("/log")
    public void log(){
        logger.trace("----------trace log----------");
        logger.debug("----------debug log----------");
        logger.info("----------info log----------");
        logger.warn("----------warn log----------");
        logger.error("----------error log----------");
    }
}
