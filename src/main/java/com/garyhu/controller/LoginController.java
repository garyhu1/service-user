package com.garyhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: garyhu
 * @since: 2018/11/13 0013
 * @decription:
 */
@Controller
public class LoginController {

    @GetMapping("/login.html")
    public String login(){

        return "login";
    }
}
