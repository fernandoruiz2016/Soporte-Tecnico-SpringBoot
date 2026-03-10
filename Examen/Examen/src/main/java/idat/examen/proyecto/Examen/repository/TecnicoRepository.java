package idat.examen.proyecto.Examen.repository;

import idat.examen.proyecto.Examen.model.Tecnico;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TecnicoRepository {
    private final Map<Integer, Tecnico> tecnicos = new HashMap<>();
    private final AtomicInteger secuencialTecnico = new AtomicInteger();

    public Tecnico create(Tecnico tecnico) {
        if(tecnico.getIdTecnico() == null) {
            tecnico.setIdTecnico(secuencialTecnico.getAndIncrement());
        }
        tecnicos.put(tecnico.getIdTecnico(), tecnico);
        return tecnico;
    }

    public List<Tecnico> list() {
        return new ArrayList<>(tecnicos.values());
    }

    public Optional<Tecnico> search(Integer idTecnico) {
        return Optional.ofNullable(tecnicos.get(idTecnico));
    }
}
