package com.ProductManagementSystem.ProductManagementSystem;

import com.ProductManagementSystem.ProductManagementSystem.entity.dj.PersonEntity;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.Person;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonEntityMapper {

    @Mapping(target = "birthPlace", ignore = true)
    PersonEntity toEntity(Person person);

    @Mapping(target = "birthPlace", ignore = true)
    Person toDto(PersonEntity personEntity);

    @Mapping(target = "birthPlace", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PersonEntity partialUpdate(Person person, @MappingTarget PersonEntity personEntity);
}