package com.ProductManagementSystem.ProductManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "entity_addresses")
public class EntityAddressEntity extends AbstractBaseEntity {

    @ManyToOne
    @JoinColumn(name = "entity_id")
    private EntEntity entity;

    @Column(name = "country")
    private String country;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "state_province")
    private String stateProvince;
}
