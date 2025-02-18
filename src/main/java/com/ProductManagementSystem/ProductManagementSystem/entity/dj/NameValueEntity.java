package com.ProductManagementSystem.ProductManagementSystem.entity.dj;

import com.ProductManagementSystem.ProductManagementSystem.entity.AbstractBaseEntity;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "dj_name_value")
@Getter
@Setter
public class NameValueEntity extends AbstractBaseEntity {
    private String firstName;
    private String middleName;
    private String surname;
    private String maidenName;
    @ElementCollection
    @CollectionTable(name = "dj_name_original_script")
    @Column(name = "original_script")
    private List<String> originalScriptName;
}
