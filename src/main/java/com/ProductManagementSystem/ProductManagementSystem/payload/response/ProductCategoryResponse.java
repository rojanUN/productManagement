package com.ProductManagementSystem.ProductManagementSystem.payload.response;

import com.ProductManagementSystem.ProductManagementSystem.entity.ProductEntity;
import com.ProductManagementSystem.ProductManagementSystem.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductCategoryResponse {
    private String name;
    private String description;
    private StatusEnum status;
    private Integer productCount;
    private List<ProductEntity> products;
}
