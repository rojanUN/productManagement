package com.ProductManagementSystem.ProductManagementSystem.service;

import com.ProductManagementSystem.ProductManagementSystem.entity.QueryCondition;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.QueryRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryBuilderService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Object> executeQuery(QueryRequest request, Class<?> entityType) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> query = cb.createQuery(Object.class);
        Root<?> root = query.from(entityType);

        List<Predicate> combinedPredicates = new ArrayList<>();
        Predicate currentGroupPredicate = null;

        for (QueryCondition condition : request.getConditions()) {
            String field = condition.getField();
            String operator = condition.getOperator();
            Object value = condition.getValue();
            String logicalOperator = condition.getLogicalOperator();

            if (value instanceof String) {
                value = ((String) value).toLowerCase();
            }

            Predicate predicate = null;

            switch (operator.toUpperCase()) {
                case "=":
                    predicate = cb.equal(cb.lower(root.get(field)), value);
                    break;
                case "LIKE":
                    if (value instanceof String) {
                        predicate = cb.like(cb.lower(root.get(field)), "%" + value + "%");
                    }
                    break;
                case "IN":
                    if (value instanceof List) {
                        predicate = root.get(field).in((List<?>) value);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported operator: " + operator);
            }

            if (currentGroupPredicate == null) {
                currentGroupPredicate = predicate;
            } else {
                if ("OR".equalsIgnoreCase(logicalOperator)) {
                    currentGroupPredicate = cb.or(currentGroupPredicate, predicate);
                } else {
                    currentGroupPredicate = cb.and(currentGroupPredicate, predicate);
                }
            }
        }

        if (currentGroupPredicate != null) {
            combinedPredicates.add(currentGroupPredicate);
        }

        Predicate finalPredicate = cb.and(combinedPredicates.toArray(new Predicate[0]));
        query.where(finalPredicate);

        if (request.getSortBy() != null && request.getSortDirection() != null) {
            if ("ASC".equalsIgnoreCase(request.getSortDirection())) {
                query.orderBy(cb.asc(root.get(request.getSortBy())));
            } else {
                query.orderBy(cb.desc(root.get(request.getSortBy())));
            }
        }

        return entityManager.createQuery(query).getResultList();
    }
}


