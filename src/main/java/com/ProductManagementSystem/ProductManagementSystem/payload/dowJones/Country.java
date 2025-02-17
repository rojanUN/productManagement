package com.ProductManagementSystem.ProductManagementSystem.payload.dowJones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Country {

    @XmlAttribute(name = "code")
    private String code;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "IsTerritory")
    private boolean isTerritory;

    @XmlAttribute(name = "ProfileURL")
    private String profileURL;

}