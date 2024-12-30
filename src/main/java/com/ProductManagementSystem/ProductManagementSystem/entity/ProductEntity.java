package com.ProductManagementSystem.ProductManagementSystem.entity;

import com.ProductManagementSystem.ProductManagementSystem.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends AbstractBaseEntity {

    private LocalDateTime createdAt;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategoryEntity category;

}
