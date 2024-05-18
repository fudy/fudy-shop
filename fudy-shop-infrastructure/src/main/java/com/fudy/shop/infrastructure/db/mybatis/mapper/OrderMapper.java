package com.fudy.shop.infrastructure.db.mybatis.mapper;

import com.fudy.shop.infrastructure.db.data.OrderDO;
import org.apache.ibatis.annotations.Insert;

public interface OrderMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,order_id,user_id,status,actual_amount,discount_amount,total_amount,payment_status,payment_time,payment_method,delivery_address_id,delivery_status,freight_amount,note";
    String COLUMNS = "id," + NO_ID_COLUMNS;

    @Insert("insert into order(" + COLUMNS + ") values(#{id}, now(), now(), #{orderId}, #{userId}, #{status}, #{actualAmount}, #{discountAmount}, #{totalAmount}, #{paymentStatus}" +
            "#{paymentTime}, #{paymentMethod}, #{deliveryAddressId}, #{deliveryStatus}, #{freightAmount}, #{note})")
    void insert(OrderDO orderDO);
}
