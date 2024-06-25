package co.edu.iudigital.app.domain.service.impl;

import co.edu.iudigital.app.domain.dto.producto.BuyRequestDTO;
import co.edu.iudigital.app.domain.dto.producto.ProductoRequestDTO;
import co.edu.iudigital.app.domain.dto.producto.ProductoResponseDTO;
import co.edu.iudigital.app.domain.mapper.ProductoMapper;
import co.edu.iudigital.app.domain.model.Categoria;
import co.edu.iudigital.app.domain.model.Producto;
import co.edu.iudigital.app.domain.model.Proveedor;
import co.edu.iudigital.app.domain.repository.CategoriaRepository;
import co.edu.iudigital.app.domain.repository.ProductoRepository;
import co.edu.iudigital.app.domain.repository.ProveedorRepository;
import co.edu.iudigital.app.domain.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainProductoServiceImpl implements ProductoService {// port

    private final ProductoMapper productoMapper = ProductoMapper.INSTANCE;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProductoResponseDTO> getProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productoMapper.toProductoResponseDtoList(productos);
    }

    @Override
    public ProductoResponseDTO createProducto(ProductoRequestDTO productoRequestDTO) {
        Categoria categoria = categoriaRepository
                .findById(productoRequestDTO.getCategoriaId())
                .orElseThrow(RuntimeException::new);
        Proveedor proveedor = proveedorRepository
                .findById(productoRequestDTO.getProveedorId())
                .orElseThrow(RuntimeException::new);

        Producto producto = productoMapper.toProducto(productoRequestDTO);
        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);

        producto = productoRepository.save(producto);

        return productoMapper.toProductoResponseDto(producto);
    }

    @Override
    public ProductoResponseDTO getProductoById(final Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return productoMapper.toProductoResponseDto(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoResponseDTO updateProductoById(Long id, ProductoRequestDTO productoRequestDTO) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        producto.setNombre(productoRequestDTO.getNombre());
        producto.setPrecioUnitario(productoRequestDTO.getPrecioUnitario());
        producto.setStock(productoRequestDTO.getStock());
        producto = productoRepository.save(producto);
        return productoMapper.toProductoResponseDto(producto);
    }

    @Override
    public ProductoResponseDTO buyProductoById(Long id, BuyRequestDTO buyRequestDTO) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        Integer stock = producto.getStock() + buyRequestDTO.getQuantity();
        producto.setStock(stock);
        producto = productoRepository.save(producto);
        return productoMapper.toProductoResponseDto(producto);
    }
}
