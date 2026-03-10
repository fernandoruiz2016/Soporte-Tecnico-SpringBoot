package idat.examen.proyecto.Examen.repository;

import idat.examen.proyecto.Examen.model.Solicitud;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SolicitudRepository {
    private final Map<Integer, Solicitud> solicitudes = new HashMap<>();
    private final AtomicInteger secuencialSolicitud = new AtomicInteger();

    public Solicitud create(Solicitud solicitud) {
        if(solicitud.getIdSolicitud() == null) {
            solicitud.setIdSolicitud(secuencialSolicitud.getAndIncrement());
        }
        solicitudes.put(solicitud.getIdSolicitud(), solicitud);
        return solicitud;
    }

    public List<Solicitud> list() {
        return new ArrayList<>(solicitudes.values());
    }

    public Optional<Solicitud> search(Integer idSolicitud) {
        return Optional.ofNullable(solicitudes.get(idSolicitud));
    }

    public Solicitud update(Solicitud solicitud) {
        solicitudes.put(solicitud.getIdSolicitud(), solicitud);
        return solicitud;
    }

    public void delete(Integer idSolicitud) {
        solicitudes.remove(idSolicitud);
    }
}
