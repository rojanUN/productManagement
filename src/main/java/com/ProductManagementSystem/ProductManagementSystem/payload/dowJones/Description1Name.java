package com.ProductManagementSystem.ProductManagementSystem.payload.dowJones;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Description1Name {

    @XmlAttribute(name = "Description1Id")
    private int description1Id;

    @XmlAttribute(name = "RecordType")
    private String recordType;

    @XmlValue
    private String value;

}
