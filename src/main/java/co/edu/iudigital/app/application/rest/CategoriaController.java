package co.edu.iudigital.app.application.rest;

import co.edu.iudigital.app.domain.model.Categoria;
import co.edu.iudigital.app.domain.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: INCLUIRLO EN EL SWAGGER
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> index() {// TODO: MIGRAR A DTO
        return ResponseEntity.ok(categoriaService.getCategorias());
    }

    @PostMapping
    public ResponseEntity<Categoria> save(// TODO: MIGRAR A DTO
          @RequestBody Categoria categoria
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoriaService.createCategoria(categoria));
    }
}
