package com.fudy.shop.domain.repository;

import com.fudy.shop.domain.modal.order.Order;

public interface OrderRepository {
    /** 创建订单 */
    void createOrder(Order order);
}
