package com.fudy.shop.application.dto.command;

import com.fudy.shop.application.dto.OrderItemDTO;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateOrderCommand {
    /** 订单号 */
    private Long orderId;

    /** 实际待支付价格 */
    private BigDecimal actualAmount;

    /** 折扣价 */
    private BigDecimal discountAmount;

    /** 总价格 */
    private BigDecimal totalAmount;

    /** 收货地址ID */
    private Long deliveryAddressId;

    /** 运费 */
    private BigDecimal freightAmount;

    /** 用户备注 */
    private String note;

    /** 商品列表 */
    private List<OrderItemDTO> orderItemDTOList;

}
