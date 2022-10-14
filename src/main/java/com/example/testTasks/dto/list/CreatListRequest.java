package com.example.testTasks.dto.list;

import com.example.testTasks.dto.product.CreateProductRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatListRequest {
    @NotBlank
    private String name;

    @Builder.Default
    private java.util.List<CreateProductRequest> createProductRequests = new ArrayList<>();
}
