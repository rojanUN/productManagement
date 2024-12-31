package com.ProductManagementSystem.ProductManagementSystem.service.specification;

import com.ProductManagementSystem.ProductManagementSystem.entity.ProductCategoryEntity;
import com.ProductManagementSystem.ProductManagementSystem.enums.StatusEnum;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.ProductSearchFilterPaginationRequest;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.format.DateTimeFormatter;

public class ProductSpecification {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static Specification<ProductCategoryEntity> product (ProductSearchFilterPaginationRequest request) {
        return  (root, query, criteriabuilder) -> {
            Predicate finalPredicate = criteriabuilder.conjunction();

            finalPredicate = criteriabuilder.equal(root.get("status"), StatusEnum.ACTIVE);

            if (StringUtils.isNotBlank(request.getSearchText())){
                Predicate searchTextPredicate = criteriabuilder.or(criteriabuilder.like(criteriabuilder.lower(root.get("name")), likePattern(request.getSearchText()).toLowerCase()));
                finalPredicate = criteriabuilder.and(searchTextPredicate);
            }

            return finalPredicate;
        };
    }

    private static String likePattern(String value) {
        return "%" + value + "%";
    }

}
