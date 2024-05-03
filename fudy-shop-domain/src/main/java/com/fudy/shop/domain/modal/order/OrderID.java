package com.fudy.shop.domain.modal.order;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@EqualsAndHashCode
public class OrderID {
    @Getter
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
