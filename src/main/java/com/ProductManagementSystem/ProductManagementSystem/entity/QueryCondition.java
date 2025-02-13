package com.ProductManagementSystem.ProductManagementSystem.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryCondition {
        private String field; // Field name, e.g., "state" or "priority"
        private String operator; // Operator, e.g., "=", "LIKE", "IN"
        private Object value; // Value for the condition
        private String logicalOperator; // AND / OR
}
