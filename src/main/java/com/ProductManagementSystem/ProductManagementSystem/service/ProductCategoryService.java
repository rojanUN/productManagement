package com.ProductManagementSystem.ProductManagementSystem.service;

import com.ProductManagementSystem.ProductManagementSystem.exception.ProductException;
import com.ProductManagementSystem.ProductManagementSystem.model.Response;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategoryRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategorySearchFilterPaginationRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategoryUpdateRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.response.ProductCategoryResponse;

import java.util.UUID;

public interface ProductCategoryService {

    Response save(ProductCategoryRequest request) throws ProductException;
    Response update(ProductCategoryUpdateRequest request) throws ProductException;
    Response delete(UUID id) throws ProductException;
    Response getAll(ProductCategorySearchFilterPaginationRequest request);
    Response getById(UUID id) throws ProductException;
    ProductCategoryResponse getCatById(UUID id) throws ProductException;

}
