package com.ProductManagementSystem.ProductManagementSystem.utils;

import com.ProductManagementSystem.ProductManagementSystem.payload.request.PaginateRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Helper {

    public static Pageable getPageable(PaginateRequest request) {
        return PageRequest.of(request.getPageNo(), request.getPageSize(), Sort.by(request.getDirection() == null ? Sort.Direction.ASC : Sort.Direction.DESC, request.getSortBy() == null ? "createdAt" : request.getSortBy()));
    }

}
