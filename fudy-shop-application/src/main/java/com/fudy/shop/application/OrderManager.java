package com.fudy.shop.application;

import com.fudy.shop.application.assembler.OrderAssembler;
import com.fudy.shop.application.dto.command.CreateOrderCommand;
import com.fudy.shop.application.dto.SimpleUserDTO;
import com.fudy.shop.domain.exception.SessionNotFoundException;
import com.fudy.shop.domain.modal.order.Order;
import com.fudy.shop.domain.modal.user.UserId;
import com.fudy.shop.domain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;

@Service
public class OrderManager {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private UserManager userManager;
    @Autowired
    private OrderAssembler assembler;

    public Long generateOrderID(HttpSession httpSession) throws Exception {
        SimpleUserDTO user = userManager.getUser(httpSession);
        if (null == user) {
            throw new SessionNotFoundException("user session not found");
        }
        return orderService.generateOrderID().getValue();
    }

    private void validate(CreateOrderCommand command) throws Exception {
        if (null == command) {
            throw new Exception("command should not be null");
        }
        if (CollectionUtils.isEmpty(command.getOrderItemDTOList())) {
            throw new Exception("order item list should not be null");
        }
        if (command.getActualAmount().intValue() < 1 || command.getActualAmount().intValue() > 1000 ) { //假设商品最大只能卖1000件
            throw new Exception("actual amount should between 1 and 1000");
        }
        //其他n个参数的校验

    }

    @Transactional
    public void placeOrder(HttpSession httpSession, CreateOrderCommand command) throws Exception {
        validate(command);
        //用户校验
        String userId = userManager.checkUser(httpSession);
        Order order = assembler.toOrder(command);
        order.setUserId(new UserId(userId));
        //商品校验
        itemService.checkItem(order);
        //价格校验
        priceService.checkPrice(order);
        //库存校验
        inventoryService.checkStock(order);
        //物流校验
        deliveryService.checkAddress(order);
        //创建订单
        orderService.createOrder(order);
        //扣减库存
        inventoryService.decreaseStock(order);
    }
}
