package com.ProductManagementSystem.ProductManagementSystem.payload.request.alQaida;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class IndividualDto {
    @XmlElement(name = "DATAID")
    private Long dataId;

    @XmlElement(name = "VERSIONNUM")
    private int versionNum;

    @XmlElement(name = "NAME_ORIGINAL_SCRIPT")
    private String nameOriginalScript;

    @XmlElement(name = "FIRST_NAME")
    private String firstName;

    @XmlElement(name = "FOURTH_NAME")
    private String fourthName;

    @XmlElement(name = "SECOND_NAME")
    private String secondName;

    @XmlElement(name = "THIRD_NAME")
    private String thirdName;

    @XmlElement(name = "UN_LIST_TYPE")
    private String unListType;

    @XmlElement(name = "REFERENCE_NUMBER")
    private String referenceNumber;

    @XmlElement(name = "LISTED_ON")
    private String listedOn;

    @XmlElement(name = "COMMENTS1")
    private String comments;

    @XmlElement(name = "GOODQUALITY")
    private boolean goodQuality;

    @XmlElementWrapper(name = "NATIONALITY")
    @XmlElement(name = "VALUE")
    private List<String> nationality;

    @XmlElementWrapper(name = "LIST_TYPE")
    @XmlElement(name = "VALUE")
    private List<String> listType;

    @XmlElementWrapper(name = "LAST_DAY_UPDATED")
    @XmlElement(name = "VALUE")
    private List<String> lastDayUpdated;

    @XmlElement(name = "INDIVIDUAL_ALIAS")
    private List<IndividualAlias> individualAliases;

    @XmlElement(name = "INDIVIDUAL_DATE_OF_BIRTH")
    private List<IndividualDateOfBirth> individualDateOfBirth;

    @XmlElement(name = "INDIVIDUAL_PLACE_OF_BIRTH")
    private IndividualPlaceOfBirth individualPlaceOfBirth;
}
