package co.edu.iudigital.app.domain.service.impl;

import co.edu.iudigital.app.domain.dto.categoria.CategoriaRequestDTO;
import co.edu.iudigital.app.domain.dto.categoria.CategoriaResponseDTO;
import co.edu.iudigital.app.domain.mapper.CategoriaMapper;
import co.edu.iudigital.app.domain.model.Categoria;
import co.edu.iudigital.app.domain.repository.CategoriaRepository;
import co.edu.iudigital.app.domain.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomainCategoriaServiceImpl implements CategoriaService {//port

    private final CategoriaMapper categoriaMapper = CategoriaMapper.INSTANCE;

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public List<CategoriaResponseDTO> getCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        // TODO: IMPLEMENTAR MAPSTRUCT CON CLASES DE MAPEO

        /* imperativa
        List<CategoriaResponseDTO> categoriaResponseDTOS = new LinkedList<>();
        for (Categoria categoria : categorias) {
            CategoriaResponseDTO categoriaResponseDTO = CategoriaResponseDTO.builder()
                    .id(categoria.getId())
                    .nombre(categoria.getNombre())
                    .descripcion(categoria.getDescripcion())
                    .createdAt(categoria.getCreatedAt())
                    .updatedAt(categoria.getUpdatedAt())
                    .build();
            categoriaResponseDTOS.add(categoriaResponseDTO);
        }
        return categoriaResponseDTOS;*/

        // funcional
        /*return categorias.stream().map(categoria -> // lambdas de Java 8: programación funcional
            CategoriaResponseDTO.builder()
                            .id(categoria.getId())
                            .nombre(categoria.getNombre())
                            .descripcion(categoria.getDescripcion())
                            .createdAt(categoria.getCreatedAt())
                            .updatedAt(categoria.getUpdatedAt())
                            .build()
        ).collect(Collectors.toList());*/
        return categoriaMapper.toCategoriaResponseDtoList(categorias);
    }

    @Override
    public CategoriaResponseDTO createCategoria(CategoriaRequestDTO categoriaRequestDTO) {
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequestDTO.getNombre());
        categoria.setDescripcion(categoriaRequestDTO.getDescripcion());
        categoria = categoriaRepository.save(categoria);

        // TODO: IMPLEMENTAR MAPSTRUCT
        /*return CategoriaResponseDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .createdAt(categoria.getCreatedAt())
                .updatedAt(categoria.getUpdatedAt())
                .build();*/
        return categoriaMapper.toCategoriaResponseDTO(categoria);
    }

    @Override
    public CategoriaResponseDTO updateCategoria(Long id, CategoriaRequestDTO categoriaRequestDTO) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if(categoriaOptional.isPresent()) {
             Categoria categoria = categoriaOptional.get();
             categoria.setNombre(
                     categoriaRequestDTO.getNombre() != null ? categoriaRequestDTO.getNombre() : categoria.getNombre()
             );
             categoria.setDescripcion(
                     categoriaRequestDTO.getDescripcion() != null ? categoriaRequestDTO.getDescripcion() : categoria.getDescripcion()
             );
            categoria = categoriaRepository.save(categoria);
            // TODO: IMPLEMENTAR MAPSTRUCT
            /*return CategoriaResponseDTO.builder()
                    .id(categoria.getId())
                    .nombre(categoria.getNombre())
                    .descripcion(categoria.getDescripcion())
                    .createdAt(categoria.getCreatedAt())
                    .updatedAt(categoria.getUpdatedAt())
                    .build();*/
            return categoriaMapper.toCategoriaResponseDTO(categoria);
        }else{
            // TODO: IMPLEMENTAR EXCEPCIONES PERSONALIZADAS.
            throw new RuntimeException("No existe Categoria que intenta actualizar");
        }

    }

    @Override
    public CategoriaResponseDTO getCategoriaById(Long id) {
        Categoria categoria =categoriaRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        // TODO: REFACTORING DE REPETICION DE CODIGO
       /* return CategoriaResponseDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .createdAt(categoria.getCreatedAt())
                .updatedAt(categoria.getUpdatedAt())
                .build();*/
        return categoriaMapper.toCategoriaResponseDTO(categoria);
    }

    @Override
    public void deleteCategoriaById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
