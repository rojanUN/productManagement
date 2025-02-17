package com.ProductManagementSystem.ProductManagementSystem.payload.dowJones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class RoleType {

    @XmlAttribute(name = "Id")
    private int id;

    @XmlAttribute(name = "name")
    private String name;

}
