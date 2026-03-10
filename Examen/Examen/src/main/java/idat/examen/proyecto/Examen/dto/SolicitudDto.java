package idat.examen.proyecto.Examen.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Data
public class SolicitudDto {
    @NotBlank(message = "La descripción del problema es obligatoria")
    @Size(min = 10, message = "La descripción debe tener al menos 10 caracteres")
    private String descripcion;

    @NotBlank(message = "La prioridad es obligatoria")
    @Pattern(regexp = "Alta|Media|Baja", message = "La prioridad debe ser: Alta, Media o Baja")
    private String prioridad;

    @NotNull(message = "El ID del cliente es obligatorio")
    @PositiveOrZero(message = "El ID del cliente debe ser un número positivo")
    private Integer idCliente;

    @NotNull(message = "El ID del técnico es obligatorio")
    @PositiveOrZero(message = "El ID del técnico debe ser un número positivo")
    private Integer idTecnico;

    private String estado = "Pendiente";
}