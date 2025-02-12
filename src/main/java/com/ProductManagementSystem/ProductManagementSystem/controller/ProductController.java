package com.ProductManagementSystem.ProductManagementSystem.controller;

import com.ProductManagementSystem.ProductManagementSystem.annotation.ProductRestController;
import com.ProductManagementSystem.ProductManagementSystem.exception.ProductException;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductRequest;
import com.ProductManagementSystem.ProductManagementSystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ProductRestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) throws ProductException {
        return ResponseEntity.ok(productService.save(request));
    }

}
