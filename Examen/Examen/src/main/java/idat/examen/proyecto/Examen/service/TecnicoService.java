package idat.examen.proyecto.Examen.service;

import idat.examen.proyecto.Examen.dto.TecnicoDto;
import idat.examen.proyecto.Examen.model.Tecnico;
import idat.examen.proyecto.Examen.repository.TecnicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TecnicoService {
    private final TecnicoRepository tecnicoRepository;

    public Tecnico create(TecnicoDto tecnicoDto) {
        Tecnico tecnico = Tecnico.builder()
                .dni(tecnicoDto.getDni())
                .nombres(tecnicoDto.getNombres())
                .apellidoPaterno(tecnicoDto.getApellidoPaterno())
                .apellidoMaterno(tecnicoDto.getApellidoMaterno())
                .especialidad(tecnicoDto.getEspecialidad())
                .edad(tecnicoDto.getEdad())
                .fechaRegistro(LocalDate.now())
                .build();
        return tecnicoRepository.create(tecnico);
    }

    public List<Tecnico> list() {
        return tecnicoRepository.list();
    }

}

