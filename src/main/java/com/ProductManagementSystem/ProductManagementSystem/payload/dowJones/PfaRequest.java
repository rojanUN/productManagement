package com.ProductManagementSystem.ProductManagementSystem.payload.dowJones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "PFA")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class PfaRequest {

    @XmlElementWrapper(name = "CountryList")
    @XmlElement(name = "CountryName")
    private List<Country> countries;

    @XmlElementWrapper(name = "OccupationList")
    @XmlElement(name = "Occupation")
    private List<IdNameRequest> occupations;

    @XmlElementWrapper(name = "RelationshipList")
    @XmlElement(name = "Relationship")
    private List<IdNameRequest> relationships;

    @XmlElementWrapper(name = "SanctionsReferencesList")
    @XmlElement(name = "ReferenceName")
    private List<ReferenceName> referenceNames;

    @XmlElementWrapper(name = "Description1List")
    @XmlElement(name = "Description1Name")
    private List<Description1Name> description1Names;

    @XmlElementWrapper(name = "Description2List")
    @XmlElement(name = "Description2Name")
    private List<Description2Name> description2Names;

    @XmlElementWrapper(name = "Description3List")
    @XmlElement(name = "Description3Name")
    private List<Description3Name> description3Names;

    @XmlElementWrapper(name = "DateTypeList")
    @XmlElement(name = "DateType")
    private List<DateType> dateTypes;

    @XmlElementWrapper(name = "NameTypeList")
    @XmlElement(name = "NameType")
    private List<NameType> nameTypes;

    @XmlElementWrapper(name = "RoleTypeList")
    @XmlElement(name = "RoleType")
    private List<RoleType> roleTypes;

    @XmlElement(name = "Records")
    private RecordWrapper records;

    @XmlElement(name = "Associations")
    private Associations associations;
}



