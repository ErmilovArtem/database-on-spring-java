package com.disgroup.database.repository;

import com.disgroup.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByOrderByIdAsc();

    List<Product> findByOrderByIdDesc();

    List<Product> findByOrderByNameAsc();

    List<Product> findByOrderByNameDesc();

    List<Product> findByOrderByImplementationCostAsc();

    List<Product> findByOrderByImplementationCostDesc();

    List<Product> findByOrderByDescriptionAsc();

    List<Product> findByOrderByDescriptionDesc();

    List<Product> findByNameContainingIgnoreCase(String keyword);
}
