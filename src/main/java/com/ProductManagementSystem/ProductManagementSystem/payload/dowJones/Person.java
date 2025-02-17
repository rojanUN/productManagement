package com.ProductManagementSystem.ProductManagementSystem.payload.dowJones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Person {

    @XmlAttribute(name = "id")
    private int personId;

    @XmlAttribute(name = "action")
    private String action;

    @XmlAttribute(name = "date")
    private String date;

    @XmlElement(name = "Gender")
    private String gender;

    @XmlElement(name = "ActiveStatus")
    private String activeStatus;

    @XmlElement(name = "Deceased")
    private String deceased;

    @XmlElementWrapper(name = "NameDetails")
    @XmlElement(name = "Name")
    private List<Name> nameDetails;

    @XmlElementWrapper(name = "Descriptions")
    @XmlElement(name = "Description")
    private List<Description> descriptions;

    @XmlElementWrapper(name = "RoleDetail")
    @XmlElement(name = "Roles")
    private List<Roles> roles;

    @XmlElementWrapper(name = "DateDetails")
    @XmlElement(name = "Date")
    private List<Date> dateDetails;

    @XmlElement(name = "Address")
    private Address address;

    @XmlElementWrapper(name = "BirthPlace")
    @XmlElement(name = "Place")
    private List<Place> birthPlace;

    @XmlElementWrapper(name = "CountryDetails")
    @XmlElement(name = "Country")
    private List<CountryDetail> countryDetails;

    @XmlElementWrapper(name = "Images")
    @XmlElement(name = "Image")
    private List<Image> images;

    @XmlElementWrapper(name = "IDNumberTypes")
    @XmlElement(name = "ID")
    private List<IdNumberType> idNumberTypes;

    @XmlElement(name = "ProfileNotes")
    private String profileNotes;

    @XmlElementWrapper(name = "SourceDescription")
    @XmlElement(name = "Source")
    private List<Source> sources;

    @XmlElementWrapper(name = "SanctionsReferences")
    @XmlElement(name = "Reference")
    private List<TimePeriod> sanctionsReferences;

}

