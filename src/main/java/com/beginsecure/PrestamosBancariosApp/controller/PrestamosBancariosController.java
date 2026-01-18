package com.beginsecure.PrestamosBancariosApp.controller;

import com.beginsecure.PrestamosBancariosApp.dto.SolicitudPrestamoDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.beginsecure.PrestamosBancariosApp.service.SolicitudPrestamoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes-prestamo")
public class PrestamosBancariosController {

    @Autowired
    SolicitudPrestamoService service;

    @PostMapping("/crear-solicitud")
    public ResponseEntity<SolicitudPrestamoDto> crearSolicitud( @Valid @RequestBody SolicitudPrestamoDto solicitud) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createSolicitud(solicitud));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SolicitudPrestamoDto>> listarSolicitudes() {
        return ResponseEntity.ok(service.getAllSolicitudes());
    }

    @GetMapping("/solicitud/{id}")
    public ResponseEntity<SolicitudPrestamoDto> obtenerSolicitud(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSolicitudById(id));
    }

    @PutMapping("/actualizar-estado/{id}")
    public ResponseEntity<SolicitudPrestamoDto> actualizarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {

        return ResponseEntity.ok(service.updateEstadoSolicitud(id, estado));
    }

    @DeleteMapping("/delete-solicitud/{id}")
    public ResponseEntity<String> deleteSolicitud(@PathVariable Long id) {
        boolean deleted = service.deleteSolicitudById(id);
        if (deleted) {
            return ResponseEntity.ok("Solicitud borrada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Solicitud no encontrada con id " + id);
        }
    }
}
