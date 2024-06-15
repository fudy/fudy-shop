package com.fudy.shop.domain.repository;

import com.fudy.shop.domain.modal.order.OrderItem;

import java.util.List;

public interface OrderItemRepository {
    void create(List<OrderItem> orderItems);
}
