package com.ProductManagementSystem.ProductManagementSystem.payload.response;

import com.ProductManagementSystem.ProductManagementSystem.enums.StatusEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponse {

    private LocalDateTime createdAt;
    private String name;
    private String description;
    private StatusEnum status;
    private Double price;
    private String categoryName;
}
