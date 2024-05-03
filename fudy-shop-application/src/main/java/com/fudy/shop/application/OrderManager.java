package com.fudy.shop.application;

import com.fudy.shop.application.dto.SimpleUserDTO;
import com.fudy.shop.domain.exception.SessionNotFoundException;
import com.fudy.shop.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class OrderManager {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserManager userManager;

    public Long generateOrderID(HttpSession httpSession) throws Exception {
        SimpleUserDTO user = userManager.getUser(httpSession);
        if (null == user) {
            throw new SessionNotFoundException("user session not found");
        }
        return orderService.generateOrderID().getValue();
    }
}
