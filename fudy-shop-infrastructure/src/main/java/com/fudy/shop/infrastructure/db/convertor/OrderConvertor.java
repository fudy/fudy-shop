package com.fudy.shop.infrastructure.db.convertor;

import com.fudy.shop.domain.modal.delivery.DeliveryStatus;
import com.fudy.shop.domain.modal.order.Order;
import com.fudy.shop.domain.modal.order.OrderID;
import com.fudy.shop.domain.modal.order.OrderStatus;
import com.fudy.shop.domain.modal.payment.PaymentMethod;
import com.fudy.shop.domain.modal.payment.PaymentStatus;
import com.fudy.shop.domain.modal.user.UserId;
import com.fudy.shop.infrastructure.db.data.OrderDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderConvertor {

    OrderDO toOrderDO(Order order);

    default Long toOrderId(OrderID orderID) {
        return null == orderID ? null : orderID.getValue();
    }

    default Long toUserId(UserId userId) {
        return null == userId ? null : userId.getValue();
    }

    default Integer toOrderStatus(OrderStatus status) {
        return null == status ? null : status.getStatusCode();
    }

    default Integer toPaymentStatus(PaymentStatus paymentStatus) {
        return null == paymentStatus ? null : paymentStatus.getValue();
    }

    default Integer toPaymentMethod(PaymentMethod method) {
        return null == method ? null : method.getValue();
    }

    default Integer toDeliveryStatus(DeliveryStatus status) {
        return null == status ? null : status.getValue();
    }
}
