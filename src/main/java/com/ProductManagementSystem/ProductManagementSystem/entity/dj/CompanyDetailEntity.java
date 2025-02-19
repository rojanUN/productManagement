package com.ProductManagementSystem.ProductManagementSystem.entity.dj;

import com.ProductManagementSystem.ProductManagementSystem.entity.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "dj_company_detail")
@Getter
@Setter
public class CompanyDetailEntity extends AbstractBaseEntity {

    @Column(name = "address_line")
    private String addressLine;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_country")
    private String addressCountry;

    private String url;

    @ManyToOne
    @JoinColumn(name = "entity_id")
    private DowEntEntity entity;
}
