package com.example.testTasks.dto.list;

import com.example.testTasks.dto.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateListRequest {
    @NotNull
    private Long id;

    private String name;

    @Builder.Default
    private java.util.List<Product> productList = new ArrayList<>();

}
