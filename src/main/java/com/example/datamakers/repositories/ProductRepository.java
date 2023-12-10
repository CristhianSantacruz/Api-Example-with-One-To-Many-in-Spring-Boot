package com.example.datamakers.repositories;


import com.example.datamakers.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends
        JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p where p.price BETWEEN ?1 AND ?2")
    List<Product> findByProductPriceInRange(BigDecimal minPrice,BigDecimal maxPrice);
}
