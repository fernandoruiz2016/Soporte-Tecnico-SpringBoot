package idat.examen.proyecto.Examen.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tecnico {
    private Integer idTecnico;
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String especialidad;
    private LocalDate fechaRegistro;
    private Integer edad;
}