package co.edu.iudigital.app.domain.service;

import co.edu.iudigital.app.domain.model.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> getCategorias();

    Categoria createCategoria(Categoria categoria);

    Categoria getCategoriaById(Long id);
}
