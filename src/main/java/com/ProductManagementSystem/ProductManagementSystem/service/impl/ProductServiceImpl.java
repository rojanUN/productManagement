package com.ProductManagementSystem.ProductManagementSystem.service.impl;

import com.ProductManagementSystem.ProductManagementSystem.entity.ProductEntity;
import com.ProductManagementSystem.ProductManagementSystem.enums.StatusEnum;
import com.ProductManagementSystem.ProductManagementSystem.exception.ProductException;
import com.ProductManagementSystem.ProductManagementSystem.mapper.ProductMapper;
import com.ProductManagementSystem.ProductManagementSystem.model.Response;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductSearchFilterPaginationRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductUpdateRequest;
import com.ProductManagementSystem.ProductManagementSystem.repository.ProductCategoryRepository;
import com.ProductManagementSystem.ProductManagementSystem.repository.ProductRepository;
import com.ProductManagementSystem.ProductManagementSystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    private final ProductMapper productMapper;

    @Override
    public void save(ProductRequest request) throws ProductException {

        productCategoryRepository.findById(request.getCategoryId()).orElseThrow( () -> new ProductException("CAT001", "Category for the id does not exist", HttpStatus.BAD_REQUEST));
        if (productRepository.existsByNameAndCategory_Id(request.getName(), request.getCategoryId())) {
            throw new ProductException("PRO000", "Product with the same name already already exists in this category", HttpStatus.BAD_REQUEST);
        }
        ProductEntity product = productMapper.requestToEntity(request);
        product.setStatus(StatusEnum.ACTIVE);
        productRepository.save(product);

    }

    @Override
    public Response update(ProductUpdateRequest request) throws ProductException {
        productRepository.findById(request.getId()).orElseThrow(() -> new ProductException("PRO001", "Product with the id does not exist", HttpStatus.BAD_REQUEST) );
        return null;
    }

    @Override
    public Response delete(ProductRequest request) throws ProductException {
        return null;
    }

    @Override
    public Response getAll(ProductSearchFilterPaginationRequest request) {
        return null;
    }

    @Override
    public Response getById(UUID id) throws ProductException {
        return null;
    }
}