package idat.examen.proyecto.Examen.controller;

import idat.examen.proyecto.Examen.dto.TecnicoDto;
import idat.examen.proyecto.Examen.model.Tecnico;
import idat.examen.proyecto.Examen.service.TecnicoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tecnicos")
@RestController
@RequiredArgsConstructor
public class TecnicoController {
    private final TecnicoService tecnicoService;

    @PostMapping
    @Operation(summary = "Crear tecnico",
            description = "Permite registrar tecnicos desde un entorno externo")
    public ResponseEntity<Tecnico> create(@Valid @RequestBody TecnicoDto tecnicoDto) {
        Tecnico tecnico = tecnicoService.create(tecnicoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnico);
    }

    @GetMapping
    @Operation(summary = "Listar tecnicos",
            description = "Permite listar tecnicos existentes")
    public ResponseEntity<List<Tecnico>> list() {
        return ResponseEntity.ok(tecnicoService.list());
    }

    @PutMapping("/{idTecnico}")
    @Operation(summary = "Actualizar tecnico",
            description = "Permite actualizar un tecnico existente")
    public ResponseEntity<Tecnico> update(@PathVariable Integer idTecnico,
                                          @Valid @RequestBody TecnicoDto tecnicoDto) {
        Tecnico tecnico = tecnicoService.update(idTecnico, tecnicoDto);
        return ResponseEntity.ok(tecnico);
    }

    @DeleteMapping("/{idTecnico}")
    @Operation(summary = "Eliminar tecnico",
            description = "Permite eliminar un tecnico por su id")
    public ResponseEntity<Void> delete(@PathVariable Integer idTecnico) {
        tecnicoService.delete(idTecnico);
        return ResponseEntity.noContent().build();
    }
}

