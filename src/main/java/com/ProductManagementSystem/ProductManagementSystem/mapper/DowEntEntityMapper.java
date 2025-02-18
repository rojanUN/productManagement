package com.ProductManagementSystem.ProductManagementSystem.mapper;

import com.ProductManagementSystem.ProductManagementSystem.entity.dj.DowEntEntity;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.Entity;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DowEntEntityMapper {
    DowEntEntity toEntity(Entity entity);

//    @AfterMapping
//    default void linkDateDetails(@MappingTarget DowEntEntity dowEntEntity) {
//        dowEntEntity.getDateDetails().forEach(dateDetail -> dateDetail.setEntity(dowEntEntity));
//    }

    Entity toDto(DowEntEntity dowEntEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DowEntEntity partialUpdate(Entity entity, @MappingTarget DowEntEntity dowEntEntity);
}