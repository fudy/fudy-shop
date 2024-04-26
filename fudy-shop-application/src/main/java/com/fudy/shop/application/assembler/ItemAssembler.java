package com.fudy.shop.application.assembler;

import com.fudy.shop.domain.modal.item.Item;
import com.fudy.shop.domain.modal.item.ItemSku;
import com.fudy.shop.item.api.dto.ItemDTO;
import com.fudy.shop.item.api.dto.ItemSkuDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ItemCommonConverter.class})
public interface ItemAssembler {
    ItemDTO toItemDTO(Item item);

    ItemSkuDTO toItemSkuDTO(ItemSku itemSku);

}
