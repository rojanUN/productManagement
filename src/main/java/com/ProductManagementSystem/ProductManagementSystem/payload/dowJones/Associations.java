package com.ProductManagementSystem.ProductManagementSystem.payload.dowJones;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "Associations")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Associations {

    @XmlElement(name = "PublicFigure")
    private List<PublicFigure> publicFigures;

}
