package com.ProductManagementSystem.ProductManagementSystem.entity.dj;

import com.ProductManagementSystem.ProductManagementSystem.entity.AbstractBaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "dj_name_detail")
@Getter
@Setter
public class NameDetailEntity extends AbstractBaseEntity {

    @Column(name = "name_type", nullable = false)
    private String nameType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "name_detail_id")
    private List<NameValueEntity> nameValues;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;
}
