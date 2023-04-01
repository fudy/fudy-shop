package com.fudy.shop.interfaces.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class HomePageController {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        log.debug("debug request");
        log.info("info request");
        log.warn("warn request");
        return "success";
    }
}
