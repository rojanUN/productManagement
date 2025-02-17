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
public class TimePeriod {

    @XmlAttribute(name = "SinceDay")
    private int sinceDay;

    @XmlAttribute(name = "SinceMonth")
    private String sinceMonth;

    @XmlAttribute(name = "SinceYear")
    private int sinceYear;

    @XmlAttribute(name = "ToDay")
    private int toDay;

    @XmlAttribute(name = "ToMonth")
    private String toMonth;

    @XmlAttribute(name = "ToYear")
    private int toYear;

    @XmlValue
    private String value;

}
