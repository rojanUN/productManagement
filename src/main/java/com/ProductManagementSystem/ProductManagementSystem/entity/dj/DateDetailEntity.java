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

@Entity
@Getter
@Setter
public class DateDetailEntity extends AbstractBaseEntity {

    @Column(name = "date_type", nullable = false)
    private String dateType;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;

//    @ManyToOne
//    @JoinColumn(name = "entity_id", nullable = false)
//    private DowEntEntity entity;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "date_detail_id")
    private List<DateValueEntity> dateValues;
}
