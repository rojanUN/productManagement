package com.ProductManagementSystem.ProductManagementSystem.payload.request;

import com.ProductManagementSystem.ProductManagementSystem.entity.QueryCondition;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QueryRequest {
    private List<QueryCondition> conditions;
    private String logicalOperator;
    private String sortBy;
    private String sortDirection;
}
