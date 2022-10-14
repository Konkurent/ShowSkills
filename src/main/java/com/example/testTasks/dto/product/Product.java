package com.example.testTasks.dto.product;

import com.example.testTasks.dto.list.ListInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;

    private String name;

    private String description;

    private Integer kcal;

    private ListInfo list;
}
