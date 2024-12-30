package com.ProductManagementSystem.ProductManagementSystem.service.impl;

import com.ProductManagementSystem.ProductManagementSystem.builder.ResponseBuilder;
import com.ProductManagementSystem.ProductManagementSystem.entity.ProductCategoryEntity;
import com.ProductManagementSystem.ProductManagementSystem.enums.StatusEnum;
import com.ProductManagementSystem.ProductManagementSystem.exception.ProductException;
import com.ProductManagementSystem.ProductManagementSystem.mapper.ProductCategoryMapper;
import com.ProductManagementSystem.ProductManagementSystem.model.Response;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategoryRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategorySearchFilterPaginationRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategoryUpdateRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.response.DataPaginationResponse;
import com.ProductManagementSystem.ProductManagementSystem.payload.response.ProductCategoryResponse;
import com.ProductManagementSystem.ProductManagementSystem.repository.ProductCategoryRepository;
import com.ProductManagementSystem.ProductManagementSystem.service.ProductCategoryService;
import com.ProductManagementSystem.ProductManagementSystem.service.specification.ProductCategorySpecification;
import com.ProductManagementSystem.ProductManagementSystem.utils.Helper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    private final ProductCategoryMapper productCategoryMapper;

    @Override
    public Response save(ProductCategoryRequest request) throws ProductException {

        if (productCategoryRepository.existsByNameAndStatusNot(request.getName(), StatusEnum.DELETED)){
            throw new ProductException("CAT000", "Category with the same name already exists", HttpStatus.BAD_REQUEST);
        }

        ProductCategoryEntity category = productCategoryMapper.requestToEntity(request);
        category.setStatus(StatusEnum.ACTIVE);
        productCategoryRepository.save(category);
        return ResponseBuilder.buildSuccessResponse(String.format("Product category created with name %s", request.getName()));
    }

    @Override
    public Response update(ProductCategoryUpdateRequest request) throws ProductException {

        ProductCategoryEntity category = productCategoryRepository.findById(request.getId()).orElseThrow(() -> new ProductException("CAT001", "Category does not exist", HttpStatus.BAD_REQUEST));
        category = productCategoryMapper.mapToEntity(request, category);
        productCategoryRepository.save(category);
        ProductCategoryResponse response = productCategoryMapper.entityToResponse(category);
        return ResponseBuilder.buildSuccessResponse("Category updated Successfully", response);

    }

    @Override
    public Response delete(UUID id) throws ProductException{

        ProductCategoryEntity category = productCategoryRepository.findById(id).orElseThrow(() -> new ProductException("CAT001", "Category does not exist", HttpStatus.BAD_REQUEST));
        category.setStatus(StatusEnum.DELETED);
        productCategoryRepository.save(category);
        return ResponseBuilder.buildSuccessResponse("Category deleted successfully");

    }

    @Override
    public Response getAll(ProductCategorySearchFilterPaginationRequest request) {

        Specification<ProductCategoryEntity> specification = ProductCategorySpecification.category(request);
        Page<ProductCategoryEntity> categoryPage = productCategoryRepository.findAll(specification, Helper.getPageable(request));
        List<ProductCategoryEntity> productCategoryEntities = categoryPage.getContent();
        List<ProductCategoryResponse> productCategoryResponses = productCategoryEntities.stream()
                .map(productCategoryMapper::entityToResponse).toList();
        DataPaginationResponse response = DataPaginationResponse.builder()
                .totalElementCount(categoryPage.getTotalElements())
                .result(productCategoryResponses)
                .build();
        return ResponseBuilder.buildSuccessResponse(response);

    }

    @Override
    public Response getById(UUID id) throws ProductException {
        ProductCategoryEntity category = productCategoryRepository.findById(id).orElseThrow( () -> new ProductException("CAT001", "Category does not exist", HttpStatus.BAD_REQUEST));
        ProductCategoryResponse response = productCategoryMapper.entityToResponse(category);
        return ResponseBuilder.buildSuccessResponse(response);
    }

}
