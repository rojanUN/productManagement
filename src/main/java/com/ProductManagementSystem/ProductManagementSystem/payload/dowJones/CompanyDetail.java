package com.ProductManagementSystem.ProductManagementSystem.payload.dowJones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class CompanyDetail {

    @XmlElement(name = "AddressLine")
    private String addressLine;

    @XmlElement(name = "AddressCity")
    private String addressCity;

    @XmlElement(name = "AddressCountry")
    private String addressCountry;

    @XmlElement(name = "URL")
    private String url;

}
