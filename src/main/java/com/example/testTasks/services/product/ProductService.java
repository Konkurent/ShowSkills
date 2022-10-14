package com.example.testTasks.services.product;

import com.example.testTasks.dto.product.CreateProductRequest;
import com.example.testTasks.dto.product.Product;
import com.example.testTasks.entities.product.ProductEtity;
import com.example.testTasks.repositories.product.ProductRepository;
import com.example.testTasks.util.convertors.ProductDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.testTasks.util.convertors.ProductDTOConverter.toDto;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll().stream().map(ProductDTOConverter::toDto).collect(Collectors.toList());
    }

    public ResponseEntity<?> getProduct(Long id) {
        return productRepository.findById(id)
                .map(ProductDTOConverter::toDto)
                .map(p -> new ResponseEntity(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @Transactional(rollbackFor = Exception.class)
    public Product saveProduct(CreateProductRequest req) {
        System.out.println(req.toString());
        ProductEtity productEtity = ProductEtity.builder()
                .name(req.getName())
                .description(req.getDescription())
                .kcal(req.getKcal())
                .build();

        return toDto(productRepository.save(productEtity));
    }
}
