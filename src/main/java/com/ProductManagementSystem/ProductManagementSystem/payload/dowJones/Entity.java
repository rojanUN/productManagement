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

@XmlRootElement(name = "Entity")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Entity {
    @XmlAttribute(name = "id")
    private int entityId;

    @XmlAttribute(name = "action")
    private String action;

    @XmlAttribute(name = "date")
    private String date;

    @XmlElementWrapper(name = "NameDetails")
    @XmlElement(name = "Name")
    private List<EntityName> nameDetails;

    @XmlElementWrapper(name = "Descriptions")
    @XmlElement(name = "Description")
    private List<Description> descriptions;

    @XmlElementWrapper(name = "DateDetails")
    @XmlElement(name = "Date")
    private List<Date> dateDetails;

    @XmlElementWrapper(name = "SanctionsReferences")
    @XmlElement(name = "Reference")
    private List<TimePeriod> sanctionsReferences;

    @XmlElement(name = "CompanyDetails")
    private List<CompanyDetail> companyDetails;

    @XmlElementWrapper(name = "IDNumberTypes")
    @XmlElement(name = "ID")
    private List<IdNumberType> idNumberTypes;

    @XmlElement(name = "ProfileNotes")
    private String profileNotes;

    @XmlElementWrapper(name = "SourceDescription")
    @XmlElement(name = "Source")
    private List<Source> sources;





}
