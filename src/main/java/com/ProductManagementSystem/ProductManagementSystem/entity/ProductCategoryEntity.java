package com.ProductManagementSystem.ProductManagementSystem.entity;

import com.ProductManagementSystem.ProductManagementSystem.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "product_category")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryEntity extends AbstractBaseEntity{

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private List<ProductEntity> products;

}
