package co.edu.iudigital.app.domain.service;

import co.edu.iudigital.app.domain.dto.producto.BuyRequestDTO;
import co.edu.iudigital.app.domain.dto.producto.ProductoRequestDTO;
import co.edu.iudigital.app.domain.dto.producto.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {

    List<ProductoResponseDTO> getProductos();

    ProductoResponseDTO createProducto(ProductoRequestDTO productoRequestDTO);

    ProductoResponseDTO getProductoById(Long id);

    void deleteById(Long id);

    ProductoResponseDTO updateProductoById(Long id, ProductoRequestDTO productoRequestDTO);

    ProductoResponseDTO buyProductoById(Long id, BuyRequestDTO buyRequestDTO);
}
