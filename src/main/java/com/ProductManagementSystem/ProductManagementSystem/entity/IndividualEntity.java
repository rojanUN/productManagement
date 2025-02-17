package com.ProductManagementSystem.ProductManagementSystem.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "individuals")
public class IndividualEntity extends AbstractBaseEntity {

    @Column(name = "data_id")
    private Long dataId;

    @Column(name = "version_num")
    private int versionNum;

    @Column(name = "name_original_script")
    private String nameOriginalScript;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "fourth_name")
    private String fourthName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "third_name")
    private String thirdName;

    @Column(name = "un_list_type")
    private String unListType;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "listed_on")
    private String listedOn;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

    @Column(name = "good_quality")
    private boolean goodQuality;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "individual_nationality", joinColumns = @JoinColumn(name = "individual_id"))
    @Column(name = "nationality")
    private List<String> nationality;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "individual_list_type", joinColumns = @JoinColumn(name = "individual_id"))
    @Column(name = "list_type")
    private List<String> listType;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "individual_last_day_updated", joinColumns = @JoinColumn(name = "individual_id"))
    @Column(name = "last_day_updated")
    private List<String> lastDayUpdated;

    @OneToMany(mappedBy = "individual", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<IndividualAliasEntity> individualAliases;

    @OneToMany(mappedBy = "individual", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<IndividualDateOfBirthEntity> individualDateOfBirth;

    @OneToOne(mappedBy = "individual", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private IndividualPlaceOfBirthEntity individualPlaceOfBirth;
}

