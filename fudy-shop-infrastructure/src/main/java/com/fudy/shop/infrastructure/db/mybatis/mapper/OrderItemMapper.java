package com.fudy.shop.infrastructure.db.mybatis.mapper;

import com.fudy.shop.infrastructure.db.data.OrderItemDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,order_id,item_id,quantity,unit_price,subtotal,sku";
    String COLUMNS = "id," + NO_ID_COLUMNS;

    /** 插入 */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into order_item(" + NO_ID_COLUMNS + ") values(now(), now(), #{orderId}, #{itemId}, #{quantity}, #{unitPrice}, #{subtotal}, #{sku})")
    void insert(OrderItemDO orderItemDO);

    /** 批量插入 */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("<script> " +
                "insert into order_item(" + NO_ID_COLUMNS + ") values " +
                "<foreach collection=\"orderItemDOList\" index=\"index\" item=\"item\" separator=\",\"> " +
                    "(now(), now(), #{item.orderId}, #{item.itemId}, #{item.quantity}, #{item.unitPrice}, #{item.subtotal}, #{item.sku})" +
                "</foreach> " +
            "</script>")
    void batchInsert(@Param("orderItemDOList") List<OrderItemDO> orderItemDOList);
}
