package com.fudy.shop.interfaces.http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePageController {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "success";
    }
}
