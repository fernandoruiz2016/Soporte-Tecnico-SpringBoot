package idat.examen.proyecto.Examen.controller;

import idat.examen.proyecto.Examen.dto.ClienteDto;
import idat.examen.proyecto.Examen.model.Cliente;
import idat.examen.proyecto.Examen.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/clientes")
@RestController
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    @Operation(summary = "Crear cliente",
            description = "Permite registrar clientes desde un entorno externo")
    public ResponseEntity<Cliente> create(@Valid @RequestBody ClienteDto clienteDto) {
        Cliente cliente = clienteService.create(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> list() {
        return ResponseEntity.ok(clienteService.list());
    }

    @PutMapping("/{idCliente}")
    @Operation(summary = "Actualizar cliente",
            description = "Permite actualizar un cliente existente")
    public ResponseEntity<Cliente> update(@PathVariable Integer idCliente,
                                          @Valid @RequestBody ClienteDto clienteDto) {
        Cliente cliente = clienteService.update(idCliente, clienteDto);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{idCliente}")
    @Operation(summary = "Eliminar cliente",
            description = "Permite eliminar un cliente por su id")
    public ResponseEntity<Void> delete(@PathVariable Integer idCliente) {
        clienteService.delete(idCliente);
        return ResponseEntity.noContent().build();
    }
}
