package com.ProductManagementSystem.ProductManagementSystem.payload.request.alQaida;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class EntityAddress {

    @XmlElement(name = "COUNTRY")
    public String country;

    @XmlElement(name = "STREET")
    public String street;

    @XmlElement(name = "CITY")
    public String city;

    @XmlElement(name = "NOTE")
    public String note;

    @XmlElement(name = "ZIP_CODE")
    public String zipCode;

    @XmlElement(name = "STATE_PROVINCE")
    public String stateProvince;
}
