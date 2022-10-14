package com.example.testTasks.util.convertors;

import com.example.testTasks.dto.list.ListInfo;
import com.example.testTasks.dto.product.Product;
import com.example.testTasks.entities.product.ProductEtity;

import java.util.Optional;

public class ProductDTOConverter {
    public static Product toDto(ProductEtity etity) {
        return Product.builder()
                .id(etity.getId())
                .name(etity.getName())
                .description(etity.getDescription())
                .kcal(etity.getKcal())
                .list(Optional.ofNullable(etity.getList()).map(l -> ListInfo.builder()
                        .id(l.getId())
                        .name(l.getName())
                        .build())
                        .orElse(null))
                .build();
    }
}
