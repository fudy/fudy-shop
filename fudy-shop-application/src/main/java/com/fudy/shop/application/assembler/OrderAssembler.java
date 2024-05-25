package com.fudy.shop.application.assembler;

import com.fudy.shop.application.dto.OrderItemDTO;
import com.fudy.shop.application.dto.command.CreateOrderCommand;
import com.fudy.shop.domain.modal.item.ItemSku;
import com.fudy.shop.domain.modal.item.ItemSkuSpec;
import com.fudy.shop.domain.modal.order.Order;
import com.fudy.shop.domain.modal.order.OrderID;
import com.fudy.shop.domain.modal.order.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderAssembler {

    @Mapping(target = "orderItems", source = ".", qualifiedByName = "toOrderItems")
    Order toOrder(CreateOrderCommand command);

    default OrderID toOrderID(Long orderId) {
        return null == orderId ? null : new OrderID(orderId);
    }

    @Named("toOrderItems")
    default List<OrderItem> toOrderItems(CreateOrderCommand command) {
        if (null == command) {
            return null;
        }
        List<OrderItemDTO> orderItemDTOList = command.getOrderItemDTOList();
        if (null == orderItemDTOList) {
            return null;
        }
        List<OrderItem> list = new ArrayList<>();
        OrderID orderId = toOrderID(command.getOrderId());
        for (OrderItemDTO dto : orderItemDTOList) {
            if (null == dto) {
                continue;
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setQuantity(dto.getQuantity());
            orderItem.setSubtotal(dto.getSubtotal());
            orderItem.setItemSku(new ItemSku(dto.getItemId(), dto.getItemSku()));
            list.add(orderItem);
        }
        return list;
    }
}
