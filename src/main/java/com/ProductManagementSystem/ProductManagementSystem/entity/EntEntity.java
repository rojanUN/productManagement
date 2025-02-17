package com.ProductManagementSystem.ProductManagementSystem.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "entities")
public class EntEntity extends AbstractBaseEntity {

    @Column(name = "data_id")
    private Long dataId;

    @Column(name = "version_num")
    private String versionNum;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "un_list_type")
    private String unListType;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "listed_on")
    private String listedOn;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

    @Column(name = "name_original_script")
    private String nameOriginalScript;

    @ElementCollection
    @CollectionTable(name = "entity_list_type", joinColumns = @JoinColumn(name = "entity_id"))
    @Column(name = "list_type")
    private List<String> listType;

    @ElementCollection
    @CollectionTable(name = "entity_last_day_updated", joinColumns = @JoinColumn(name = "entity_id"))
    @Column(name = "last_day_updated")
    private List<String> lastDayUpdated;

    @OneToOne(mappedBy = "entity", cascade = CascadeType.ALL, orphanRemoval = true)
    private EntityAliasEntity entityAlias;

    @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntityAddressEntity> entityAddress;
}
