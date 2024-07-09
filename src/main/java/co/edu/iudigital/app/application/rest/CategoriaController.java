package co.edu.iudigital.app.application.rest;

import co.edu.iudigital.app.domain.dto.categoria.CategoriaRequestDTO;
import co.edu.iudigital.app.domain.dto.categoria.CategoriaResponseDTO;
import co.edu.iudigital.app.domain.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> index() {
        return ResponseEntity.ok(categoriaService.getCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(categoriaService.getCategoriaById(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> save(
          @Valid @RequestBody CategoriaRequestDTO request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoriaService.createCategoria(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> update(
            @PathVariable(value = "id") Long id,
            @RequestBody CategoriaRequestDTO request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoriaService.updateCategoria(id, request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        categoriaService.deleteCategoriaById(id);
    }

}
