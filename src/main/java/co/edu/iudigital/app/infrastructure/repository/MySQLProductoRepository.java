package co.edu.iudigital.app.infrastructure.repository;

import co.edu.iudigital.app.domain.model.Producto;
import co.edu.iudigital.app.domain.repository.ProductoRepository;
import co.edu.iudigital.app.infrastructure.mapper.ProductoMapper;
import co.edu.iudigital.app.infrastructure.persistence.jpa.entity.ProductoEntity;
import co.edu.iudigital.app.infrastructure.persistence.jpa.repository.ProductoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MySQLProductoRepository implements ProductoRepository {

    private final ProductoMapper productoMapper = ProductoMapper.INSTANCE;

    @Autowired
    private ProductoJpaRepository productoJpaRepository;

    @Override
    public List<Producto> findAll() {
        List<ProductoEntity> productoEntities = productoJpaRepository.findAll();
        return productoMapper.toProductoList(productoEntities);
    }

    @Override
    public Producto save(Producto producto) {
        ProductoEntity productoEntity = productoMapper.toProductoEntity(producto);
        productoEntity = productoJpaRepository.save(productoEntity);
        return productoMapper.toProducto(productoEntity);
    }

    @Override
    public Optional<Producto> findById(Long id) {
        ProductoEntity productoEntity = productoJpaRepository.findById(id).orElseThrow(RuntimeException::new);
        Producto producto = productoMapper.toProducto(productoEntity);
        return Optional.of(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoJpaRepository.deleteById(id);
    }
}
