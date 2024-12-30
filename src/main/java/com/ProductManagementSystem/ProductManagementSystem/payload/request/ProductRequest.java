package com.ProductManagementSystem.ProductManagementSystem.payload.request;

import com.ProductManagementSystem.ProductManagementSystem.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductRequest {

    private LocalDateTime createdAt;

    @NotBlank
    private String name;
    private String description;
    private StatusEnum status;
    private Double price;

    @NotBlank
    private UUID categoryId;

}
