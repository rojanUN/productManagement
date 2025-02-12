package com.ProductManagementSystem.ProductManagementSystem.controller;

import com.ProductManagementSystem.ProductManagementSystem.annotation.ProductRestController;
import com.ProductManagementSystem.ProductManagementSystem.entity.ProductCategoryEntity;
import com.ProductManagementSystem.ProductManagementSystem.entity.ProductEntity;
import com.ProductManagementSystem.ProductManagementSystem.exception.ProductException;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategoryRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategorySearchFilterPaginationRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategoryUpdateRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.response.ProductCategoryResponse;
import com.ProductManagementSystem.ProductManagementSystem.repository.ProductCategoryRepository;
import com.ProductManagementSystem.ProductManagementSystem.repository.ProductRepository;
import com.ProductManagementSystem.ProductManagementSystem.service.ProductCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@ProductRestController
@RequiredArgsConstructor
@Controller
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;

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

    @GetMapping("/hello")
    public ResponseEntity<?> helloWorld(){
        return ResponseEntity.ok("Hello World");
    }

    @QueryMapping
    public ProductCategoryResponse categoryById(@Argument UUID id) throws ProductException {
        return productCategoryService.getCatById(id);
    }

    @SchemaMapping
    public List<ProductEntity> author(ProductCategoryEntity category) {
        return productRepository.findAllByCategory(category);
    }

}
