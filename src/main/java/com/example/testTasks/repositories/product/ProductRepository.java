package com.example.testTasks.repositories.product;

import com.example.testTasks.entities.product.ProductEtity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEtity, Long> {
}
