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

    public Tecnico update(Integer idTecnico, TecnicoDto tecnicoDto) {
        Tecnico tecnico = tecnicoRepository.search(idTecnico)
                .orElseThrow(() -> new RuntimeException("Tecnico no encontrado"));

        tecnico.setDni(tecnicoDto.getDni());
        tecnico.setNombres(tecnicoDto.getNombres());
        tecnico.setApellidoPaterno(tecnicoDto.getApellidoPaterno());
        tecnico.setApellidoMaterno(tecnicoDto.getApellidoMaterno());
        tecnico.setEspecialidad(tecnicoDto.getEspecialidad());
        tecnico.setEdad(tecnicoDto.getEdad());

        return tecnicoRepository.update(tecnico);
    }

    public void delete(Integer idTecnico) {
        tecnicoRepository.search(idTecnico)
                .orElseThrow(() -> new RuntimeException("Tecnico no encontrado"));

        tecnicoRepository.delete(idTecnico);
    }
}

