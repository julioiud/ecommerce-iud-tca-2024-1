package co.edu.iudigital.app.infrastructure.repository;

import co.edu.iudigital.app.domain.model.Producto;
import co.edu.iudigital.app.domain.repository.ProductoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MySQLProductoRepository implements ProductoRepository {
    @Override
    public List<Producto> findAll() {
        return null;
    }

    @Override
    public Producto save(Producto producto) {
        return null;
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Producto update(Long id, Producto producto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
