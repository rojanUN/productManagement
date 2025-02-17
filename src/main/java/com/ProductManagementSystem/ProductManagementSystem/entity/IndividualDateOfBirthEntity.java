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
@Table(name = "individual_dates_of_birth")
public class IndividualDateOfBirthEntity extends AbstractBaseEntity {

    @ManyToOne
    @JoinColumn(name = "individual_id")
    private IndividualEntity individual;

    @Column(name = "type_of_date")
    private String typeOfDate;

    @Column(name = "date")
    private String date;

    @Column(name = "year")
    private String year;
}

