package com.fudy.shop.infrastructure.db.repository;

import com.fudy.shop.domain.modal.order.OrderItem;
import com.fudy.shop.domain.repository.OrderItemRepository;
import com.fudy.shop.infrastructure.db.convertor.OrderItemConvertor;
import com.fudy.shop.infrastructure.db.data.OrderItemDO;
import com.fudy.shop.infrastructure.db.mybatis.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {
    @Autowired
    private OrderItemMapper mapper;
    @Autowired
    private OrderItemConvertor convertor;

    @Override
    public void create(List<OrderItem> orderItems) {
        List<OrderItemDO> list = convertor.toOrderItems(orderItems);
        mapper.batchInsert(list);
    }
}
