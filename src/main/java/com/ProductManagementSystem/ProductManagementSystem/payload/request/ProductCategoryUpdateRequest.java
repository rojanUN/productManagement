package com.ProductManagementSystem.ProductManagementSystem.payload.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ProductCategoryUpdateRequest {

    @NotNull
    private UUID id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

}
