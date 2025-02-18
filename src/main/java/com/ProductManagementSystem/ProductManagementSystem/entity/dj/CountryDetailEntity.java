package com.ProductManagementSystem.ProductManagementSystem.entity.dj;

import com.ProductManagementSystem.ProductManagementSystem.entity.AbstractBaseEntity;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "dj_country_detail")
@Getter
@Setter
public class CountryDetailEntity extends AbstractBaseEntity {
    @Column(name = "country_type", nullable = false)
    private String countryType;

    @ElementCollection
    @CollectionTable(name = "dj_country_value")
    @Column(name = "country_value")
    private List<String> countryValues;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;

}
