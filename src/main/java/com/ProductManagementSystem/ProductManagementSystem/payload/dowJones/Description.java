package com.ProductManagementSystem.ProductManagementSystem.payload.dowJones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Description {

    @XmlAttribute(name = "Description1")
    private String description1Id;

    @XmlAttribute(name = "Description2")
    private String description2Id;

    @XmlAttribute(name = "Description3")
    private String description3Id;

}
