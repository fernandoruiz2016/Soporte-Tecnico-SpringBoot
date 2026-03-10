package idat.examen.proyecto.Examen.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Solicitud {
    private Integer idSolicitud;
    private String descripcion;
    private String estado; // Ejemplo: "Pendiente", "En Proceso", "Completado"
    private LocalDate fechaReporte;
    private String prioridad; // Ejemplo: "Alta", "Media", "Baja"
    private Integer idCliente;
    private Integer idTecnico;
}