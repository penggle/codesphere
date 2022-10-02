package com.penglecode.xmodule.security.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author peng2.peng
 * @version 1.0.0
 */
@Controller
@RequestMapping("/anon")
public class AnonController {

    @GetMapping("/help")
    public String help() {
        return "anon/help";
    }

}
