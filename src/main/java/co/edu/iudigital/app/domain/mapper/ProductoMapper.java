package co.edu.iudigital.app.domain.mapper;

import co.edu.iudigital.app.domain.dto.producto.ProductoRequestDTO;
import co.edu.iudigital.app.domain.dto.producto.ProductoResponseDTO;
import co.edu.iudigital.app.domain.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {

    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    ProductoResponseDTO toProductoResponseDto(Producto producto);

    /*@Mappings( { // cuando el nombre de atributos sean diferentes
            @Mapping(source = "proveedor", target = "proveedorResponseDTO"),
            @Mapping(source = "", target = "")
    })*/
    List<ProductoResponseDTO> toProductoResponseDtoList(List<Producto> productos);

    Producto toProducto(ProductoRequestDTO productoRequestDTO);
}
