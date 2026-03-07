package idat.examen.proyecto.Examen.service;

import idat.examen.proyecto.Examen.dto.ClienteDto;
import idat.examen.proyecto.Examen.model.Cliente;
import idat.examen.proyecto.Examen.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente create(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .dni(clienteDto.getDni())
                .nombres(clienteDto.getNombres())
                .apellidoPaterno(clienteDto.getApellidoPaterno())
                .apellidoMaterno(clienteDto.getApellidoMaterno())
                .edad(clienteDto.getEdad())
                .fechaRegistro(LocalDate.now())
                .build();
        return clienteRepository.create(cliente);
    }

    public List<Cliente> list() {
        return clienteRepository.list();
    }

}

