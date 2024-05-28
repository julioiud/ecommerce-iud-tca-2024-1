package co.edu.iudigital.app.infrastructure.repository;

import co.edu.iudigital.app.domain.model.Proveedor;
import co.edu.iudigital.app.domain.repository.ProductoRepository;
import co.edu.iudigital.app.domain.repository.ProveedorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MySQLProveedorRepository implements ProveedorRepository {
    @Override
    public List<Proveedor> findAll() {
        return null;
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return null;
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        return Optional.empty();
    }
}
