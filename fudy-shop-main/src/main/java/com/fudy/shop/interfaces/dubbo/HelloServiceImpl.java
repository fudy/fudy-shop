package com.fudy.shop.interfaces.dubbo;

import com.fudy.shop.item.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0")
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
