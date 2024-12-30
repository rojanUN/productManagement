package com.ProductManagementSystem.ProductManagementSystem.mapper;

import com.ProductManagementSystem.ProductManagementSystem.entity.ProductCategoryEntity;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategoryRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductCategoryUpdateRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.response.ProductCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCategoryMapper {


    ProductCategoryEntity requestToEntity(ProductCategoryRequest request);

    ProductCategoryEntity mapToEntity(ProductCategoryUpdateRequest request, @MappingTarget ProductCategoryEntity entity);

    ProductCategoryEntity requestToEntity(ProductCategoryUpdateRequest request);

    ProductCategoryResponse entityToResponse(ProductCategoryEntity entity);
}
