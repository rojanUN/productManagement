package com.ProductManagementSystem.ProductManagementSystem.entity.dj;

import com.ProductManagementSystem.ProductManagementSystem.entity.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "dj_date_value")
@Getter
@Setter
public class DateValueEntity extends AbstractBaseEntity {

    @Column(name = "day")
    private int day;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private int year;

}
