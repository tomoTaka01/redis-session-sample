package com.example.redissessionsample.controller;

import com.example.redissessionsample.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @RequestMapping("/")
    public String home() {
        logger.info("start home method");
        return "input1";
    }
}
