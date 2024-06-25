package co.edu.iudigital.app.application.rest;

import co.edu.iudigital.app.domain.dto.proveedor.ProveedorRequestDTO;
import co.edu.iudigital.app.domain.dto.proveedor.ProveedorResponseDTO;
import co.edu.iudigital.app.domain.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorResponseDTO>> index() {
        return ResponseEntity.ok(proveedorService.getProveedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponseDTO> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(proveedorService.getProveedorById(id));
    }

    @PostMapping
    public ResponseEntity<ProveedorResponseDTO> save(// TODO: validation
                                                     @RequestBody ProveedorRequestDTO request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(proveedorService.createProveedor(request));
    }
}
