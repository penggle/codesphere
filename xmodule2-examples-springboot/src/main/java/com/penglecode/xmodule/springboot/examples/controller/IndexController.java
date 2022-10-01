package com.penglecode.xmodule.springboot.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author pengpeng
 * @version 1.0.0
 */
@Controller
public class IndexController {

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!");
        return "index";
    }

}
