package com.fudy.shop.interfaces.http;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class MainController {

    @GetMapping("/*")
    public String index(ModelMap map) {
        map.put("cssFiles", Arrays.asList("forget_password.d116754d.css", "index.32f4290a.css", "index.70ca10ae.css", "login.25aa6676.css", "registry.4d3884ed.css"));
        map.put("jsFiles", Arrays.asList("login.7a2162d3.js", "modify-password-success.df71cf41.js", "registry.c27a8daf.js", "index.63a80766.js", "index.f30a2f53.js", "forget_password.01e99a39.js", "captcha.906660c8.js"));
        return "index";
    }
}
