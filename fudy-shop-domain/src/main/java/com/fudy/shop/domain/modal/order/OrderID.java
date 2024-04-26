package com.fudy.shop.domain.modal.order;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import lombok.NonNull;

public class OrderID {
    private final Long value;

    public OrderID(@NonNull Long value) {
        this.value = value;
    }

    public OrderID() {
        this.value = newOrderId();
    }

    private Long newOrderId() {
        return new SnowflakeGenerator().next();
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
