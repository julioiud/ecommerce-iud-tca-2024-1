package co.edu.iudigital.app.domain.repository;

import co.edu.iudigital.app.domain.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository { // port

    List<Categoria> findAll();

    Categoria save(Categoria categoria);

    Optional<Categoria> findById(Long id);

    void deleteById(Long id);
}
