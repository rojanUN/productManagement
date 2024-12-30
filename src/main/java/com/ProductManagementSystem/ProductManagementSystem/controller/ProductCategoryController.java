package com.ProductManagementSystem.ProductManagementSystem.controller;

import com.ProductManagementSystem.ProductManagementSystem.annotation.ProductRestController;
import com.ProductManagementSystem.ProductManagementSystem.exception.ProductException;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategoryRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategorySearchFilterPaginationRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategoryUpdateRequest;
import com.ProductManagementSystem.ProductManagementSystem.service.ProductCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@ProductRestController
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody @Valid ProductCategoryRequest request) throws ProductException {
        return ResponseEntity.ok(productCategoryService.save(request));
    }

    @PutMapping("/category")
    public ResponseEntity<?> updateCategory(@Valid @RequestBody ProductCategoryUpdateRequest request) throws ProductException {
        return ResponseEntity.ok(productCategoryService.update(request));
    }

    @PostMapping("/category/all")
    public ResponseEntity<?> getAllCategories(@Valid @RequestBody ProductCategorySearchFilterPaginationRequest request) {
        return ResponseEntity.ok(productCategoryService.getAll(request));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductCategory(@PathVariable UUID id) throws ProductException {
        return ResponseEntity.ok(productCategoryService.getById(id));
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable UUID id) throws ProductException {
        return ResponseEntity.ok(productCategoryService.delete(id));
    }

}
