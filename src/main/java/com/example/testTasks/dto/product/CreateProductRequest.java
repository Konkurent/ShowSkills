package com.example.testTasks.dto.product;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateProductRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Integer kcal;
}
