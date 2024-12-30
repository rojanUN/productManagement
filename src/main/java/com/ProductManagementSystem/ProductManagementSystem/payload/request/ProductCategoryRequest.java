package com.ProductManagementSystem.ProductManagementSystem.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductCategoryRequest {

    @NotBlank(message = "Name is required")
    private String name;
    private String description;

}
