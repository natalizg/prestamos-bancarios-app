package com.beginsecure.PrestamosBancariosApp.mapper;

import com.beginsecure.PrestamosBancariosApp.domain.SolicitudPrestamo;
import com.beginsecure.PrestamosBancariosApp.dto.SolicitudPrestamoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SolicitudPrestamoMapper {

    SolicitudPrestamoDto toDto(SolicitudPrestamo entity);

    SolicitudPrestamo toEntity(SolicitudPrestamoDto dto);

}
