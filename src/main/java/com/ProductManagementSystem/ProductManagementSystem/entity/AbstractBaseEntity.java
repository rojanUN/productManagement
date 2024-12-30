package com.ProductManagementSystem.ProductManagementSystem.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Version
    private int version;

}