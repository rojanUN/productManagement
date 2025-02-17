package com.ProductManagementSystem.ProductManagementSystem.payload.request.alQaida;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class IndividualPlaceOfBirth {
    @XmlElement(name = "STATE_PROVINCE")
    private String stateProvince;

    @XmlElement(name = "COUNTRY")
    private String country;

    @XmlElement(name = "CITY")
    private String city;
}