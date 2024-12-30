package com.ProductManagementSystem.ProductManagementSystem.repository;

import com.ProductManagementSystem.ProductManagementSystem.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    boolean existsByNameAndCategory_Id(String name, UUID categoryId);

}
