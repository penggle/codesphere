package com.penglecode.xmodule.security.examples.controller;

import com.penglecode.xmodule.common.security.servlet.util.SpringSecurityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pengpeng
 * @version 1.0.0
 */
@Controller
public class IndexController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        UserDetails loginUser = SpringSecurityUtils.getCurrentAuthenticatedUser();
        model.addAttribute("message", String.format("Welcome %s!", loginUser.getUsername()));
        model.addAttribute("loginUser", loginUser);
        return "index";
    }

}
