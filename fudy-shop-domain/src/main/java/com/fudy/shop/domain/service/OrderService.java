package com.fudy.shop.domain.service;

import com.fudy.shop.domain.modal.order.OrderID;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public OrderID generateOrderID() {
        return new OrderID();
    }
}
