package com.ProductManagementSystem.ProductManagementSystem.payload.request;

import com.ProductManagementSystem.ProductManagementSystem.enums.StatusEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductUpdateRequest {

    private UUID id;
    private LocalDateTime createdAt;
    private String name;
    private String description;
    private StatusEnum status;
    private Double price;
    private UUID categoryId;

}
