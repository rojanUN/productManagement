package com.ProductManagementSystem.ProductManagementSystem.entity.dj;

import com.ProductManagementSystem.ProductManagementSystem.entity.AbstractBaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "dj_person")
@Getter
@Setter
public class PersonEntity extends AbstractBaseEntity {

    @Column(name = "person_id")
    private int personId;

    @Column(name = "action")
    private String action;

    @Column(name = "date")
    private String date;

    @Column(name = "gender")
    private String gender;

    @Column(name = "active_status")
    private String activeStatus;

    @Column(name = "deceased")
    private boolean deceased;

    @Column(name = "profile_notes", columnDefinition = "TEXT")
    private String profileNotes;

    @ElementCollection
    @CollectionTable(name = "dj_birth_place")
    @Column(name = "birth_place")
    private List<String> birthPlace;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NameDetailEntity> nameDetails;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DateDetailEntity> dateDetails;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CountryDetailEntity> countryDetails;
//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<DescriptionEntity> descriptions;
//
//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<RoleEntity> roles;
//
//
//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ImageEntity> images;
//
//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<IdNumberTypeEntity> idNumberTypes;
//
//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<SourceEntity> sources;
//
//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<SanctionsReferenceEntity> sanctionsReferences;

}

