package co.edu.iudigital.app.application.rest;

import co.edu.iudigital.app.domain.dto.producto.BuyRequestDTO;
import co.edu.iudigital.app.domain.dto.producto.ProductoRequestDTO;
import co.edu.iudigital.app.domain.dto.producto.ProductoResponseDTO;
import co.edu.iudigital.app.domain.service.ProductoService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Endpoints Productos Controller"})
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @Operation(summary = "Obtiene todos los productos",
            description= "Obtiene todos los productos")
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> index() {
        return ResponseEntity.ok(productoService.getProductos());
    }

    @Operation(summary = "Obtiene un producto por su ID",
            description= "Obtiene un producto por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(productoService.getProductoById(id));
    }

    @Operation(summary = "Guarda un Producto",
            description= "Guarda un Producto")
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> save(// TODO: validation
                                                     @RequestBody ProductoRequestDTO request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productoService.createProducto(request));
    }

    @Operation(summary = "Actualiza un Producto",
            description= "Actualiza un Producto")
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> update(
            @PathVariable(value = "id") Long id,
            @RequestBody ProductoRequestDTO request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productoService.updateProductoById(id, request));
    }

    @Operation(summary = "Borra un Producto por su ID",
            description= "Borra un Producto por su ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        productoService.deleteById(id);
    }

    @Operation(summary = "Compra productos por ID",
            description= "Actualiza el stock de un producto por su ID")
    @PatchMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buy(
            @PathVariable(value = "id") Long id,
            @RequestBody BuyRequestDTO request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productoService.buyProductoById(id, request));
    }

}
