package co.edu.iudigital.app.infrastructure.mapper;

import co.edu.iudigital.app.domain.model.Categoria;
import co.edu.iudigital.app.infrastructure.persistence.jpa.entity.CategoriaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaMapper {

    public Categoria toCategoria(CategoriaEntity categoriaEntity) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaEntity.getId());
        categoria.setNombre(categoriaEntity.getNombre());
        categoria.setDescripcion(categoriaEntity.getDescripcion());
        categoria.setCreatedAt(categoriaEntity.getCreatedAt());
        categoria.setUpdatedAt(categoriaEntity.getUpdatedAt());
        return categoria;
    }

    public List<Categoria> toCategorias(List<CategoriaEntity> categoriaEntities) {
        return categoriaEntities.stream()
                .map(categoriaEntity -> toCategoria(categoriaEntity))
                .collect(Collectors.toList());

    }

    public CategoriaEntity toCategoriEntity(Categoria categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(categoria.getId());
        categoriaEntity.setNombre(categoria.getNombre());
        categoriaEntity.setDescripcion(categoria.getDescripcion());
        categoriaEntity.setCreatedAt(categoria.getCreatedAt());
        categoriaEntity.setUpdatedAt(categoria.getUpdatedAt());
        return categoriaEntity;
    }
}

