package com.ProductManagementSystem.ProductManagementSystem.payload.dowJones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Associate {
    @XmlAttribute(name = "id")
    private String associateId;

    @XmlAttribute(name = "code")
    private String associateCode;

    @XmlAttribute(name = "ex")
    private String associateEx;
}
