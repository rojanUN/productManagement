package com.ProductManagementSystem.ProductManagementSystem.service;

import com.ProductManagementSystem.ProductManagementSystem.exception.ProductException;
import com.ProductManagementSystem.ProductManagementSystem.model.Response;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductSearchFilterPaginationRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductUpdateRequest;

import java.util.UUID;

public interface ProductService {

    Response save(ProductRequest request) throws ProductException;
    Response update(ProductUpdateRequest request) throws ProductException;
    Response delete(UUID id) throws ProductException;
    Response getAll(ProductSearchFilterPaginationRequest request);
    Response getById(UUID id) throws ProductException;

}
