package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("test")
    public String test() {
        return "test";
    }

    @RequestMapping("holiday")
    public String holiday() {
        return "holiday";
    }

    @RequestMapping("wait")
    public String waits() {
        return "wait_approval";
    }
}
