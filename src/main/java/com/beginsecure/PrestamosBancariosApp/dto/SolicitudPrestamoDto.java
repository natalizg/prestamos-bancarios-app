package com.beginsecure.PrestamosBancariosApp.dto;

import com.beginsecure.PrestamosBancariosApp.enums.EnumEstadoPrestamo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudPrestamoDto {

    private Long id;

    @NotBlank(message = "El nombre del solicitante es obligatorio")
    private String nombreSolicitante;

    @NotNull(message = "El importe solicitado es obligatorio")
    @Positive(message = "El importe debe ser mayor que 0")
    private Double importeSolicitado;

    @NotBlank(message = "La divisa es obligatoria")
    @Size(min = 3, max = 3, message = "La divisa debe tener 3 letras (EUR, USD)")
    private String divisa;

    @NotBlank(message = "El documento de identidad es obligatorio")
    private String documentoIdentidad;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDateTime fechaCreacion;

    private EnumEstadoPrestamo estado;
}
