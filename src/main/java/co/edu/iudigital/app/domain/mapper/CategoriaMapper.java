package co.edu.iudigital.app.domain.mapper;

import co.edu.iudigital.app.domain.dto.categoria.CategoriaResponseDTO;
import co.edu.iudigital.app.domain.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);
    CategoriaResponseDTO toCategoriaResponseDTO(Categoria categoria);

    List<CategoriaResponseDTO> toCategoriaResponseDtoList(List<Categoria> categorias);
}
