package com.beginsecure.PrestamosBancariosApp.service;

import com.beginsecure.PrestamosBancariosApp.dto.SolicitudPrestamoDto;
import com.beginsecure.PrestamosBancariosApp.enums.EnumEstadoPrestamo;

import java.util.List;
import java.util.Optional;

public interface SolicitudPrestamoService {

    SolicitudPrestamoDto createSolicitud(SolicitudPrestamoDto solicitud);

    List<SolicitudPrestamoDto> getAllSolicitudes();

    SolicitudPrestamoDto getSolicitudById(Long id);

    SolicitudPrestamoDto updateEstadoSolicitud(Long id, String estado);

    boolean deleteSolicitudById(Long id);

}
