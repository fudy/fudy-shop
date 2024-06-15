package com.fudy.shop.infrastructure.db.convertor;

import com.fudy.shop.domain.modal.order.OrderItem;
import com.fudy.shop.infrastructure.db.data.OrderItemDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderConvertor.class)
public interface OrderItemConvertor {

    @Mapping(source = "itemSku.itemId", target = "itemId")
    @Mapping(source = "itemSku.spec.stringValue", target = "sku")
    OrderItemDO toOrderItem(OrderItem orderItem);

    List<OrderItemDO> toOrderItems(List<OrderItem> orderItems);
}
