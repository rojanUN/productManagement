package com.ProductManagementSystem.ProductManagementSystem.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategorySearchFilterPaginationRequest extends PaginateRequest {

    private String searchText;

    private String status;
    private String createdAtFrom;
    private String createdAtTo;

}
