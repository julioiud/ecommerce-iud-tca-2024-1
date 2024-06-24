package co.edu.iudigital.app.domain.service;

import co.edu.iudigital.app.domain.dto.categoria.CategoriaRequestDTO;
import co.edu.iudigital.app.domain.dto.categoria.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaService {

    List<CategoriaResponseDTO> getCategorias();

    CategoriaResponseDTO createCategoria(CategoriaRequestDTO categoriaRequestDTO);

    CategoriaResponseDTO updateCategoria(Long id, CategoriaRequestDTO categoriaRequestDTO);

    CategoriaResponseDTO getCategoriaById(Long id);

    void deleteCategoriaById(Long id);
}
