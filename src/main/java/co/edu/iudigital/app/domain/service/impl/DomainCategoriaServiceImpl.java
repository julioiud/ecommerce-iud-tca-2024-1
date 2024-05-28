package co.edu.iudigital.app.domain.service.impl;

import co.edu.iudigital.app.domain.model.Categoria;
import co.edu.iudigital.app.domain.repository.CategoriaRepository;
import co.edu.iudigital.app.domain.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainCategoriaServiceImpl implements CategoriaService {//port

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
