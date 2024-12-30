package com.ProductManagementSystem.ProductManagementSystem.mapper;

import com.ProductManagementSystem.ProductManagementSystem.entity.ProductEntity;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductEntity requestToEntity(ProductRequest productRequest);

}
