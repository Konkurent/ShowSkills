package com.example.testTasks.controllers;

import com.example.testTasks.dto.product.CreateProductRequest;
import com.example.testTasks.dto.product.Product;
import com.example.testTasks.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@Valid @RequestParam @NotNull Long id) {
        return productService.getProduct(id);
    }

    @PostMapping()
    public Product saveProduct(@Valid @RequestBody CreateProductRequest req) {
        return productService.saveProduct(req);
    }
}
