package com.ProductManagementSystem.ProductManagementSystem.repository;

import com.ProductManagementSystem.ProductManagementSystem.entity.ProductCategoryEntity;
import com.ProductManagementSystem.ProductManagementSystem.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, UUID>, JpaSpecificationExecutor<ProductCategoryEntity> {

    boolean existsByNameAndStatusNot(String name, StatusEnum status);

}
