package com.ProductManagementSystem.ProductManagementSystem.payload.request.alQaida;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class IndividualAlias {
    @XmlElement(name = "QUALITY")
    private String quality;

    @XmlElement(name = "ALIAS_NAME")
    private String aliasName;

    @XmlElement(name = "NOTE")
    private String note;

    @XmlElement(name = "DATE_OF_BIRTH")
    private String dateOfBirth;
}