package com.fudy.shop.infrastructure.db.repository;

import com.fudy.shop.domain.modal.order.Order;
import com.fudy.shop.domain.repository.OrderRepository;
import com.fudy.shop.infrastructure.db.convertor.OrderConvertor;
import com.fudy.shop.infrastructure.db.data.OrderDO;
import com.fudy.shop.infrastructure.db.mybatis.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderConvertor convertor;

    @Override
    public void createOrder(Order order) {
        OrderDO orderDO = convertor.toOrderDO(order);
        orderMapper.insert(orderDO);
    }
}
