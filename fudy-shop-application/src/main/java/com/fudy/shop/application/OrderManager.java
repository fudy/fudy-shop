package com.fudy.shop.application;

import com.fudy.shop.application.assembler.OrderAssembler;
import com.fudy.shop.application.dto.command.CreateOrderCommand;
import com.fudy.shop.application.dto.SimpleUserDTO;
import com.fudy.shop.domain.exception.SessionNotFoundException;
import com.fudy.shop.domain.modal.order.Order;
import com.fudy.shop.domain.modal.user.UserId;
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
    @Autowired
    private OrderAssembler assembler;

    public Long generateOrderID(HttpSession httpSession) throws Exception {
        SimpleUserDTO user = userManager.getUser(httpSession);
        if (null == user) {
            throw new SessionNotFoundException("user session not found");
        }
        return orderService.generateOrderID().getValue();
    }

    public void placeOrder(HttpSession httpSession, CreateOrderCommand command) throws Exception {
        SimpleUserDTO user = userManager.getUser(httpSession);
        if (null == user) {
            throw new SessionNotFoundException("user session not found");
        }
        Order order = assembler.toOrder(command);
        order.setUserId(new UserId(user.getId()));
        //TODO
    }
}
