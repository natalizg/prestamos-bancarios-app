package com.beginsecure.PrestamosBancariosApp.domain;

import com.beginsecure.PrestamosBancariosApp.enums.EnumEstadoPrestamo;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "solicitud_prestamo")
public class SolicitudPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre_solicitante")
    private String nombreSolicitante;

    @Column(name="importe_solicitado")
    private Double importeSolicitado;

    @Column(name="divisa")
    private String divisa;

    @Column(name="documento_identidad")
    private String documentoIdentidad;

    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name="estado")
    @Enumerated(EnumType.STRING)
    private EnumEstadoPrestamo estado;
}


