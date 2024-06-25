package co.edu.iudigital.app.infrastructure.repository;

import co.edu.iudigital.app.domain.model.Proveedor;
import co.edu.iudigital.app.domain.repository.ProveedorRepository;
import co.edu.iudigital.app.infrastructure.mapper.ProveedorMapper;
import co.edu.iudigital.app.infrastructure.persistence.jpa.entity.ProveedorEntity;
import co.edu.iudigital.app.infrastructure.persistence.jpa.repository.ProveedorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MySQLProveedorRepository implements ProveedorRepository {

    private final ProveedorMapper proveedorMapper = ProveedorMapper.INSTANCE;

    @Autowired
    private ProveedorJpaRepository proveedorJpaRepository;

    @Override
    public List<Proveedor> findAll() {
        List<ProveedorEntity> proveedorEntities =  proveedorJpaRepository.findAll();
        return proveedorMapper.toProveedors(proveedorEntities);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        ProveedorEntity proveedorEntity = proveedorMapper.toProveedorEntity(proveedor);
        proveedorEntity = proveedorJpaRepository.save(proveedorEntity);
        return proveedorMapper.toProveedor(proveedorEntity);
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        Optional<ProveedorEntity> proveedorEntityOptional = proveedorJpaRepository.findById(id);
        if(proveedorEntityOptional.isPresent()) {
            ProveedorEntity proveedorEntity = proveedorEntityOptional.get();
            Proveedor proveedor = proveedorMapper.toProveedor(proveedorEntity);
            return Optional.of(proveedor);
        }
        return Optional.empty();
    }
}
