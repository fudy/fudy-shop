package com.fudy.shop.interfaces.dubbo;

import com.fudy.shop.common.Result;
import com.fudy.shop.interfaces.manager.ItemManagerInterface;
import com.fudy.shop.item.api.ItemService;
import com.fudy.shop.item.api.dto.ItemDTO;
import com.fudy.shop.item.api.dto.ItemQuery;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(version = "1.0.0")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemManagerInterface itemManager;

    @Override
    public Result<ItemDTO> getItem(ItemQuery query) {
        try {
            ItemDTO data = itemManager.getItem(query);
            return Result.success(data);
        } catch (Exception e) {
            return Result.fail(null, e.getMessage());
        }
    }
}
