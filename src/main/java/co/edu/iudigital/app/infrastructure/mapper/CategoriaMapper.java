package co.edu.iudigital.app.infrastructure.mapper;

import co.edu.iudigital.app.domain.model.Categoria;
import co.edu.iudigital.app.infrastructure.persistence.jpa.entity.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria toCategoria(CategoriaEntity categoriaEntity);

    List<Categoria> toCategorias(List<CategoriaEntity> categoriaEntities);

    CategoriaEntity toCategoriEntity(Categoria categoria);
}

