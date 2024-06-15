package com.fudy.shop.domain.service;

import com.fudy.shop.domain.modal.order.Order;
import com.fudy.shop.domain.modal.order.OrderID;
import com.fudy.shop.domain.repository.OrderItemRepository;
import com.fudy.shop.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository repository;
    private OrderItemRepository itemRepository;

    @Autowired
    public OrderService(OrderRepository repository, OrderItemRepository itemRepository) {
        this.repository = repository;
        this.itemRepository = itemRepository;
    }

    public OrderID generateOrderID() {
        return new OrderID();
    }

    /** 创建订单 */
    public void createOrder(Order order) {
        //创建主订单
        this.repository.createOrder(order);
        //创建子订单
        this.itemRepository.create(order.getOrderItems());
    }
}
