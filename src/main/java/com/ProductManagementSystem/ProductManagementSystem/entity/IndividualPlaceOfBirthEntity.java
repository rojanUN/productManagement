package com.ProductManagementSystem.ProductManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "individual_places_of_birth")
public class IndividualPlaceOfBirthEntity extends AbstractBaseEntity{

    @OneToOne
    @JoinColumn(name = "individual_id")
    private IndividualEntity individual;

    @Column(name = "state_province")
    private String stateProvince;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;
}
