package co.edu.iudigital.app.infrastructure.mapper;

import co.edu.iudigital.app.domain.model.Proveedor;
import co.edu.iudigital.app.infrastructure.persistence.jpa.entity.ProveedorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProveedorMapper {

    ProveedorMapper INSTANCE = Mappers.getMapper(ProveedorMapper.class);

    Proveedor toProveedor(ProveedorEntity proveedorEntity);

    List<Proveedor> toProveedors(List<ProveedorEntity> proveedorEntities);

    ProveedorEntity toProveedorEntity(Proveedor proveedor);

}
