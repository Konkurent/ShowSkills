package com.example.testTasks.util.convertors;

import com.example.testTasks.dto.list.List;
import com.example.testTasks.entities.list.ListEntity;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListDTOConverter {
    public static List toDto(ListEntity entity) {
        return List.builder()
                .id(entity.getId())
                .name(entity.getName())
                .products(Optional.ofNullable(entity.getProducts()).stream()
                        .flatMap(Collection::stream)
                        .map(ProductDTOConverter::toDto)
                        .collect(Collectors.toList()))
                .build();
    }
}
