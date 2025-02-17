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
@Table(name = "individual_aliases")
public class IndividualAliasEntity extends AbstractBaseEntity {

    @ManyToOne
    @JoinColumn(name = "individual_id")
    private IndividualEntity individual;

    @Column(name = "quality")
    private String quality;

    @Column(name = "alias_name")
    private String aliasName;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "date_of_birth")
    private String dateOfBirth;
}
