package com.beginsecure.PrestamosBancariosApp.service.serviceImpl;

import com.beginsecure.PrestamosBancariosApp.domain.SolicitudPrestamo;
import com.beginsecure.PrestamosBancariosApp.dto.SolicitudPrestamoDto;
import com.beginsecure.PrestamosBancariosApp.enums.EnumEstadoPrestamo;
import com.beginsecure.PrestamosBancariosApp.mapper.SolicitudPrestamoMapper;
import com.beginsecure.PrestamosBancariosApp.repository.SolicitudPrestamoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beginsecure.PrestamosBancariosApp.service.SolicitudPrestamoService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SolicitudPrestamoServiceImpl implements SolicitudPrestamoService {

    @Autowired
    SolicitudPrestamoRepository repository;

    @Autowired
    SolicitudPrestamoMapper mapper;

    @Override
    public SolicitudPrestamoDto createSolicitud(SolicitudPrestamoDto solicitud) {
        solicitud.setFechaCreacion(LocalDateTime.now());
        solicitud.setEstado(EnumEstadoPrestamo.PENDIENTE);
        SolicitudPrestamo registro = repository.save(mapper.toEntity(solicitud));
        return mapper.toDto(registro);
    }

    @Override
    public List<SolicitudPrestamoDto> getAllSolicitudes() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }


    @Override
    public SolicitudPrestamoDto getSolicitudById(Long id) {
        Optional<SolicitudPrestamo> opt = repository.findById(id);
        if (opt.isPresent()) {
            return mapper.toDto(opt.get());
        } else {
            throw new EntityNotFoundException("No se encontró la solicitud con id " + id);
        }
    }


    @Override
    public SolicitudPrestamoDto updateEstadoSolicitud(Long id, String nuevoEstado) {

        if (!estadoValido(nuevoEstado)) {
            throw new IllegalArgumentException("Estado inválido: " + nuevoEstado);
        }

        SolicitudPrestamo registroSolicitud = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la solicitud con id " + id));

        if (!puedeCambiarEstado(registroSolicitud.getEstado(), EnumEstadoPrestamo.valueOf(nuevoEstado.toUpperCase()))) {
            throw new IllegalStateException(
                    "No se puede cambiar el estado de " + registroSolicitud.getEstado() + " a " + nuevoEstado.toUpperCase()
            );
        }
        registroSolicitud.setEstado(EnumEstadoPrestamo.valueOf(nuevoEstado.toUpperCase()));
        return mapper.toDto(repository.save(registroSolicitud));
    }

    @Override
    public boolean deleteSolicitudById(Long id) {
        Optional<SolicitudPrestamo> opt = repository.findById(id);
        if (opt.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    private boolean puedeCambiarEstado(EnumEstadoPrestamo estadoActual, EnumEstadoPrestamo estadoNuevo) {

        switch (estadoActual) {
            case PENDIENTE:
                return estadoNuevo == EnumEstadoPrestamo.APROBADA
                        || estadoNuevo == EnumEstadoPrestamo.RECHAZADA;

            case APROBADA:
                return estadoNuevo == EnumEstadoPrestamo.CANCELADA;

            default:
                return false;
        }
    }

    private boolean estadoValido(String estado) {
        for (EnumEstadoPrestamo e : EnumEstadoPrestamo.values()) {
            if (e.name().equals(estado.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
