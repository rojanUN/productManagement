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
@Table(name = "entity_aliases")
public class EntityAliasEntity extends AbstractBaseEntity {

    @OneToOne
    @JoinColumn(name = "entity_id")
    private EntEntity entity;

    @Column(name = "quality")
    private String quality;

    @Column(name = "alias_name")
    private String aliasName;
}

