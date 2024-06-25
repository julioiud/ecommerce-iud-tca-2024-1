package co.edu.iudigital.app.infrastructure.repository;

import co.edu.iudigital.app.domain.model.Categoria;
import co.edu.iudigital.app.domain.repository.CategoriaRepository;
import co.edu.iudigital.app.infrastructure.mapper.CategoriaMapper;
import co.edu.iudigital.app.infrastructure.persistence.jpa.entity.CategoriaEntity;
import co.edu.iudigital.app.infrastructure.persistence.jpa.repository.CategoriaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MySQLCategoriaRepository implements CategoriaRepository {

    private final CategoriaMapper categoriaMapper = CategoriaMapper.INSTANCE;

    @Autowired
    private CategoriaJpaRepository categoriaJpaRepository;

    @Override
    public List<Categoria> findAll() {
        List<CategoriaEntity> categoriaEntities =  categoriaJpaRepository.findAll();
        return categoriaMapper.toCategorias(categoriaEntities);
    }

    @Override
    public Categoria save(Categoria categoria) {
        CategoriaEntity categoriaEntity = categoriaMapper.toCategoriEntity(categoria);
        categoriaEntity = categoriaJpaRepository.save(categoriaEntity);
        return categoriaMapper.toCategoria(categoriaEntity);
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        Optional<CategoriaEntity> categoriaOptional = categoriaJpaRepository.findById(id);
        if(categoriaOptional.isPresent()) {
            CategoriaEntity categoriaEntity = categoriaOptional.get();
            Categoria categoria = categoriaMapper.toCategoria(categoriaEntity);
            return Optional.of(categoria);
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        categoriaJpaRepository.deleteById(id);
    }
}
