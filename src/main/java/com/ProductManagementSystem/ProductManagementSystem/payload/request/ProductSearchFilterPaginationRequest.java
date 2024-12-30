package com.ProductManagementSystem.ProductManagementSystem.payload.request;

import lombok.Data;

@Data
public class ProductSearchFilterPaginationRequest {

    private String searchText;

    private String status;
    private String createdAtFrom;
    private String createdAtTo;

}
