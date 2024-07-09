package co.edu.iudigital.app.domain.service;

import co.edu.iudigital.app.domain.dto.producto.BuyRequestDTO;
import co.edu.iudigital.app.domain.dto.producto.ProductoRequestDTO;
import co.edu.iudigital.app.domain.dto.producto.ProductoResponseDTO;
import co.edu.iudigital.app.domain.exceptions.InternalServerErrorException;
import co.edu.iudigital.app.domain.exceptions.RestException;

import java.util.List;

public interface ProductoService {

    List<ProductoResponseDTO> getProductos() throws RestException;

    ProductoResponseDTO createProducto(ProductoRequestDTO productoRequestDTO) throws RestException;

    ProductoResponseDTO getProductoById(Long id) throws RestException;

    void deleteById(Long id) throws RestException;

    ProductoResponseDTO updateProductoById(Long id, ProductoRequestDTO productoRequestDTO) throws RestException;

    ProductoResponseDTO buyProductoById(Long id, BuyRequestDTO buyRequestDTO) throws RestException;
}
