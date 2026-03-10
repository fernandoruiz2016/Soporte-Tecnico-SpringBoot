package idat.examen.proyecto.Examen.controller;

import idat.examen.proyecto.Examen.dto.SolicitudDto;
import idat.examen.proyecto.Examen.model.Solicitud;
import idat.examen.proyecto.Examen.service.SolicitudService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/solicitudes")
@RestController
@RequiredArgsConstructor
public class SolicitudController {
    private final SolicitudService solicitudService;

    @PostMapping
    @Operation(summary = "Crear solicitud",
            description = "Permite registrar solicitudes desde un entorno externo")
    public ResponseEntity<Solicitud> create(@Valid @RequestBody SolicitudDto solicitudDto) {
        Solicitud solicitud = solicitudService.create(solicitudDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitud);
    }

    @GetMapping
    @Operation(summary = "Listar solicitudes",
            description = "Permite listar solicitudes existentes")
    public ResponseEntity<List<Solicitud>> list() {
        return ResponseEntity.ok(solicitudService.list());
    }

    @PutMapping("/{idSolicitud}")
    @Operation(summary = "Actualizar solicitud",
            description = "Permite actualizar una solicitud existente")
    public ResponseEntity<Solicitud> update(@PathVariable Integer idSolicitud,
                                          @Valid @RequestBody SolicitudDto solicitudDto) {
        Solicitud solicitud = solicitudService.update(idSolicitud, solicitudDto);
        return ResponseEntity.ok(solicitud);
    }

    @DeleteMapping("/{idSolicitud}")
    @Operation(summary = "Eliminar solicitud",
            description = "Permite eliminar una solicitud por su id")
    public ResponseEntity<Void> delete(@PathVariable Integer idSolicitud) {
        solicitudService.delete(idSolicitud);
        return ResponseEntity.noContent().build();
    }
}
