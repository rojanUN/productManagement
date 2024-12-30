package com.ProductManagementSystem.ProductManagementSystem.payload.request;

import lombok.Data;

@Data
public class PaginateRequest{

    Integer pageNo;
    Integer pageSize;
    String sortBy;
    String direction;

}
