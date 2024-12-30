package com.ProductManagementSystem.ProductManagementSystem.payload.response;

import com.ProductManagementSystem.ProductManagementSystem.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategoryResponse {

    private String name;
    private String description;
    private StatusEnum status;

}
