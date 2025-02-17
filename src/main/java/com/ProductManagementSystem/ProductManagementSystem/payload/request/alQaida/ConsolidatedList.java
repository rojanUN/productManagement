package com.ProductManagementSystem.ProductManagementSystem.payload.request.alQaida;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "CONSOLIDATED_LIST")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class ConsolidatedList {

    @XmlElementWrapper(name = "INDIVIDUALS")
    @XmlElement(name = "INDIVIDUAL")
    List<IndividualDto> individuals;

    @XmlElementWrapper(name = "ENTITIES")
    @XmlElement(name = "ENTITY")
    List<EntityDto> entities;

    @XmlAttribute(name = "dateGenerated")
    private String dateGenerated;

}
