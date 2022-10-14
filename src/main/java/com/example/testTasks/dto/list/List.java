package com.example.testTasks.dto.list;

import java.util.ArrayList;

import com.example.testTasks.dto.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class List {
    private Long id;

    private String name;

    @Builder.Default
    private java.util.List<Product> products = new ArrayList<Product>();
}
