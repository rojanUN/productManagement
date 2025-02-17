package com.ProductManagementSystem.ProductManagementSystem.payload.dowJones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class DateValue {

    @XmlAttribute(name = "Day")
    private int day;

    @XmlAttribute(name = "Month")
    private String month;

    @XmlAttribute(name = "Year")
    private int year;
}
