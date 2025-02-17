package com.ProductManagementSystem.ProductManagementSystem.payload.request.alQaida;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class EntityDto {
    @XmlElement(name = "DATAID")
    public Long dataId;

    @XmlElement(name = "VERSIONNUM")
    public String versionNum;

    @XmlElement(name = "FIRST_NAME")
    public String firstName;

    @XmlElement(name = "UN_LIST_TYPE")
    public String unListType;

    @XmlElement(name = "REFERENCE_NUMBER")
    public String referenceNumber;

    @XmlElement(name = "LISTED_ON")
    public String listedOn;

    @XmlElement(name = "COMMENTS1")
    public String comments1;

    @XmlElement(name = "NAME_ORIGINAL_SCRIPT")
    public String nameOriginalScript;

    @XmlElementWrapper(name = "LIST_TYPE")
    @XmlElement(name = "VALUE")
    public List<String> listType;

    @XmlElementWrapper(name = "LAST_DAY_UPDATED")
    @XmlElement(name = "VALUE")
    public List<String> lastDayUpdated;

    @XmlElement(name = "ENTITY_ALIAS")
    public EntityAlias entityAlias;

    @XmlElement(name = "ENTITY_ADDRESS")
    public List<EntityAddress> entityAddress;

    @XmlElement(name = "SORT_KEY")
    public String sortKey;

    @XmlElement(name = "SORT_KEY_LAST_MOD")
    public String sortKeyLastMod;
}

