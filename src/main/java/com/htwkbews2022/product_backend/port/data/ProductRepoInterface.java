
package com.htwkbews2022.product_backend.port.data;

import com.htwkbews2022.product_backend.core.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepoInterface extends JpaRepository<Product, UUID> {
}