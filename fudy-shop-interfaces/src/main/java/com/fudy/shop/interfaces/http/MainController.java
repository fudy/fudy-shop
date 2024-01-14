package com.fudy.shop.interfaces.http;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("message", "Hello World");
        map.addAttribute("jsFileURL", "https://www.thymeleaf.org/scripts/thymeleaf.js");
        return "index";
    }
}
