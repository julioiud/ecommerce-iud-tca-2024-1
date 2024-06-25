package co.edu.iudigital.app.infrastructure.mapper;

import co.edu.iudigital.app.domain.model.Producto;
import co.edu.iudigital.app.infrastructure.persistence.jpa.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {

    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    Producto toProducto(ProductoEntity productoEntity);

    ProductoEntity toProductoEntity(Producto producto);

    List<Producto> toProductoList(List<ProductoEntity> productoEntities);
}
