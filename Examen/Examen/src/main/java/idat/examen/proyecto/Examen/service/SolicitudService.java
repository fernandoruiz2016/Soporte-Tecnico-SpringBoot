package idat.examen.proyecto.Examen.service;

import idat.examen.proyecto.Examen.dto.SolicitudDto;
import idat.examen.proyecto.Examen.model.Solicitud;
import idat.examen.proyecto.Examen.repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudService {
    private final SolicitudRepository solicitudRepository;

    public Solicitud create(SolicitudDto dto) {
        Solicitud solicitud = Solicitud.builder()
                .descripcion(dto.getDescripcion())
                .prioridad(dto.getPrioridad())
                .idCliente(dto.getIdCliente())
                .idTecnico(dto.getIdTecnico())
                .estado("Pendiente") // Estado inicial por defecto
                .fechaReporte(LocalDate.now())
                .build();
        return solicitudRepository.create(solicitud);
    }

    public List<Solicitud> list() {
        return solicitudRepository.list();
    }

    public Solicitud update(Integer idSolicitud, SolicitudDto dto) {
        Solicitud solicitud = solicitudRepository.search(idSolicitud)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID: " + idSolicitud));

        solicitud.setDescripcion(dto.getDescripcion());
        solicitud.setPrioridad(dto.getPrioridad());
        solicitud.setPrioridad(dto.getEstado());
        solicitud.setIdCliente(dto.getIdCliente());
        solicitud.setIdTecnico(dto.getIdTecnico());

        return solicitudRepository.update(solicitud);
    }

    public void delete(Integer idSolicitud) {
        solicitudRepository.search(idSolicitud)
                .orElseThrow(() -> new RuntimeException("No se pudo eliminar: Solicitud con ID " + idSolicitud + " no encontrada"));

        solicitudRepository.delete(idSolicitud);
    }
}
