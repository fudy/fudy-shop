package com.fudy.shop.interfaces.http;

import com.fudy.shop.application.OrderManager;
import com.fudy.shop.application.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private OrderManager orderManager;

    @PostMapping("/api/orders/ids")
    public Result<Long> generateOrderID() {
        try {
            Long orderID = orderManager.generateOrderID(httpSession);
            return Result.success(orderID);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
}
