package com.example.datamakers.persistence;
import com.example.datamakers.models.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
public interface IProductDAO {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    void save(Product product);
    void deleteById(Long id);

    List<Product> findByPriceInRange(BigDecimal minPrice,BigDecimal maxPrice);
}
