package com.fudy.shop.application;

import com.fudy.shop.application.assembler.ItemAssembler;
import com.fudy.shop.domain.repository.ItemRepository;
import com.fudy.shop.domain.modal.item.Item;
import com.fudy.shop.item.api.dto.ItemDTO;
import com.fudy.shop.item.api.dto.ItemQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

@Validated
@Service
public class ItemManager {
    @Autowired
    private ItemRepository repository;
    @Autowired
    private ItemAssembler assembler;

    private void validate(ItemQuery query) {
        Objects.requireNonNull(query, "query should not be null");
        Objects.requireNonNull(query.getItemId(), "query should not be null");
    }

    public ItemDTO getItem(@Valid ItemQuery query) throws Exception {
        validate(query);
        Item item = repository.getItem(query.getItemId());
        return assembler.toItemDTO(item);
    }

}
