package idat.examen.proyecto.Examen.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteDto {
    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 caracteres")
    private String dni;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @NotBlank(message = "El apellido paterno es obligatorio")
    private String apellidoPaterno;

    private String apellidoMaterno;

    private LocalDate fechaRegistro;

    @Positive(message = "La edad debe ser un número positivo")
    private Integer edad;
}