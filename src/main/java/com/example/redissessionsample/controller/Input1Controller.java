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
public class Input1Controller {
    private static final Logger logger = LoggerFactory.getLogger(Input1Controller.class);

    @ModelAttribute("genders")
    public List<String> genders() {
        return Arrays.asList("male", "female");
    }

    @PostMapping("/input1")
    public String input1(@ModelAttribute("user") User user) {
        logger.info("start input1 method user=[{}]", user.toString());
        return "input2";
    }
}
