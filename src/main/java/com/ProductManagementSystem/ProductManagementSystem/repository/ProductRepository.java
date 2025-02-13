package com.ProductManagementSystem.ProductManagementSystem.repository;

import com.ProductManagementSystem.ProductManagementSystem.entity.ProductCategoryEntity;
import com.ProductManagementSystem.ProductManagementSystem.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    boolean existsByNameAndCategory_Id(String name, UUID categoryId);

    boolean existsByIdAndNameAndCategory_Id(UUID id, String name, UUID categoryId);

    List<ProductEntity> findAllByCategory(ProductCategoryEntity category);

    Integer countByCategory(ProductCategoryEntity category);
}
