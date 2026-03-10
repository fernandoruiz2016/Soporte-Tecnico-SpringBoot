package idat.examen.proyecto.Examen.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorException {
    private LocalDateTime fechaHora;
    private int status;
    private String error;
    private List<String> mensaje;
    private String ruta;
}
