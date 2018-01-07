package com.example.redissessionsample.controller;

import com.example.redissessionsample.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes("user")
public class Input2Controller {
    private static final Logger logger = LoggerFactory.getLogger(Input2Controller.class);

    @ModelAttribute("occupations")
    public List<String> occupations() {
        return Arrays.asList("teacher", "developer", "designer", "other");
    }

    @PostMapping("/input2")
    public String input2(@ModelAttribute User user) {
        logger.info("start input2 method user=[{}]", user.toString());
        return "input3";
    }
}
