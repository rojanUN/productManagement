package com.ProductManagementSystem.ProductManagementSystem.payload.dowJones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class IdNumberType {

    @XmlAttribute(name = "IDType")
    private String idType;

    @XmlAttribute(name = "IDnotes")
    private String idNotes;

    @XmlElement(name = "IDValue")
    private String idValue;

}
