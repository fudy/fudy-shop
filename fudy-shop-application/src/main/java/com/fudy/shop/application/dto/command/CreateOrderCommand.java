package com.fudy.shop.application.dto.command;

import com.fudy.shop.application.dto.OrderItemDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateOrderCommand {
    /** 订单号 */
    @Positive(message = "订单号必须大于0")
    private Long orderId;

    /** 实际待支付价格 */
    @Positive(message = "实际支付价格必须大于0")
    private BigDecimal actualAmount;

    /** 折扣价 */
    private BigDecimal discountAmount;

    /** 总价格 */
    private BigDecimal totalAmount;

    /** 收货地址ID */
    @NotNull(message = "收货地址不能为空")
    private Long deliveryAddressId;

    /** 运费 */
    private BigDecimal freightAmount;

    /** 用户备注 */
    private String note;

    /** 商品列表 */
    @Size(min = 1, message = "订单中的商品数量必须大于0")
    private List<OrderItemDTO> orderItemDTOList;

}
