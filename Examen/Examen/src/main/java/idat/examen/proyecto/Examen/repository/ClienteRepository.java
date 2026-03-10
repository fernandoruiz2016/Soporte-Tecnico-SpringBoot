package idat.examen.proyecto.Examen.repository;

import idat.examen.proyecto.Examen.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ClienteRepository {
    private final Map<Integer, Cliente> clientes = new HashMap<>();
    private final AtomicInteger secuencialCliente = new AtomicInteger();

    public Cliente create(Cliente cliente) {
        if(cliente.getIdCliente() == null) {
            cliente.setIdCliente(secuencialCliente.getAndIncrement());
        }
        clientes.put(cliente.getIdCliente(), cliente);
        return cliente;
    }

    public List<Cliente> list() {
        return new ArrayList<>(clientes.values());
    }

    public Optional<Cliente> search(Integer idCliente) {
        return Optional.ofNullable(clientes.get(idCliente));
    }

    public Cliente update(Cliente cliente) {
        clientes.put(cliente.getIdCliente(), cliente);
        return cliente;
    }

    public void delete(Integer idCliente) {
        clientes.remove(idCliente);
    }
}
