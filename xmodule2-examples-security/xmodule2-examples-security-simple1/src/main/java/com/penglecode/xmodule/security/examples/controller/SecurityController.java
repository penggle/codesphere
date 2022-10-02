package com.penglecode.xmodule.security.examples.controller;

import com.penglecode.xmodule.common.security.servlet.util.SpringSecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pengpeng
 * @version 1.0.0
 */
@Controller
public class SecurityController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response,
                        String error, Model model) {
        if(error != null) {
            Exception exception = SpringSecurityUtils.getAuthenticationException(request);
            model.addAttribute("error", Boolean.TRUE);
            model.addAttribute("message", exception.getMessage());
        }
        return "login";
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "common/403";
    }

}
