package co.edu.iudigital.app.domain.repository;

import co.edu.iudigital.app.domain.model.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorRepository { // port

    List<Proveedor> findAll();

    Proveedor save(Proveedor proveedor);

    Optional<Proveedor> findById(Long id);
}
