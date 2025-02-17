package com.ProductManagementSystem.ProductManagementSystem.payload.request.alQaida;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class IndividualDateOfBirth {
    @XmlElement(name = "TYPE_OF_DATE")
    private String typeOfDate;

    @XmlElement(name = "DATE")
    private String date;

    @XmlElement(name = "YEAR")
    private String year;
}
