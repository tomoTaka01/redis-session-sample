package com.example.redissessionsample.controller;

import com.example.redissessionsample.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class Input3Controller {
    private static final Logger logger = LoggerFactory.getLogger(Input3Controller.class);

    @PostMapping("/input3")
    public String input3(@ModelAttribute User user) {
        logger.info("start input3 method user=[{}]", user.toString());
        return "inputcomplete";
    }
}
