package co.edu.iudigital.app.domain.service.impl;

import co.edu.iudigital.app.domain.dto.ErrorDTO;
import co.edu.iudigital.app.domain.dto.producto.BuyRequestDTO;
import co.edu.iudigital.app.domain.dto.producto.ProductoRequestDTO;
import co.edu.iudigital.app.domain.dto.producto.ProductoResponseDTO;
import co.edu.iudigital.app.domain.exceptions.InternalServerErrorException;
import co.edu.iudigital.app.domain.exceptions.NotFoundException;
import co.edu.iudigital.app.domain.exceptions.RestException;
import co.edu.iudigital.app.domain.mapper.ProductoMapper;
import co.edu.iudigital.app.domain.model.Categoria;
import co.edu.iudigital.app.domain.model.Producto;
import co.edu.iudigital.app.domain.model.Proveedor;
import co.edu.iudigital.app.domain.repository.CategoriaRepository;
import co.edu.iudigital.app.domain.repository.ProductoRepository;
import co.edu.iudigital.app.domain.repository.ProveedorRepository;
import co.edu.iudigital.app.domain.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List<ProductoResponseDTO> getProductos() throws RestException {
        try{
            List<Producto> productos = productoRepository.findAll();
            return productoMapper.toProductoResponseDtoList(productos);
        }catch (Exception e) {
            throw new InternalServerErrorException(
                    ErrorDTO.builder()
                            .error("Error General")
                            .message(e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .date(LocalDateTime.now())
                            .build()
            );
        }

    }

    @Override
    public ProductoResponseDTO createProducto(final ProductoRequestDTO productoRequestDTO) throws RestException {
        Categoria categoria = categoriaRepository
                .findById(productoRequestDTO.getCategoriaId())
                .orElseThrow(() -> new NotFoundException(
                        ErrorDTO.builder()
                                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                                .message("No existe Categoria")
                                .status(HttpStatus.NOT_FOUND.value())
                                .date(LocalDateTime.now())
                                .build()
                ));

        Proveedor proveedor = proveedorRepository
                .findById(productoRequestDTO.getProveedorId())
                .orElseThrow(() -> new NotFoundException(
                        ErrorDTO.builder()
                                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                                .message("No existe Proveedor")
                                .status(HttpStatus.NOT_FOUND.value())
                                .date(LocalDateTime.now())
                                .build())
                );
        try{
            Producto producto = productoMapper.toProducto(productoRequestDTO);
            producto.setCategoria(categoria);
            producto.setProveedor(proveedor);

            producto = productoRepository.save(producto);

            return productoMapper.toProductoResponseDto(producto);
        }catch (Exception e) {
            throw new InternalServerErrorException(
                    ErrorDTO.builder()
                            .error("Error General")
                            .message(e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .date(LocalDateTime.now())
                            .build()
            );
        }

    }

    @Override
    public ProductoResponseDTO getProductoById(final Long id) throws RestException {
        Producto producto = findProductoBy(id);
        try{
            return productoMapper.toProductoResponseDto(producto);
        }catch (Exception e) {
            throw new InternalServerErrorException(
                    ErrorDTO.builder()
                            .error("Error General")
                            .message(e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .date(LocalDateTime.now())
                            .build()
            );
        }
    }

    @Override
    public void deleteById(final Long id) throws RestException {
        try{
            productoRepository.deleteById(id);
        }catch (Exception e) {
            throw new InternalServerErrorException(
                    ErrorDTO.builder()
                            .error("Error General")
                            .message(e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .date(LocalDateTime.now())
                            .build()
            );
        }
    }

    @Override
    public ProductoResponseDTO updateProductoById(final Long id, final ProductoRequestDTO productoRequestDTO) throws RestException {
        Producto producto = findProductoBy(id);
        try{
            producto.setNombre(productoRequestDTO.getNombre());
            producto.setPrecioUnitario(productoRequestDTO.getPrecioUnitario());
            producto.setStock(productoRequestDTO.getStock());
            producto = productoRepository.save(producto);
            return productoMapper.toProductoResponseDto(producto);
        }catch (Exception e) {
            throw new InternalServerErrorException(
                    ErrorDTO.builder()
                            .error("Error General")
                            .message(e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .date(LocalDateTime.now())
                            .build()
            );
        }

    }

    @Override
    public ProductoResponseDTO buyProductoById(final Long id, final BuyRequestDTO buyRequestDTO) throws RestException {
        Producto producto = findProductoBy(id);
        try{
            Integer stock = producto.getStock() + buyRequestDTO.getQuantity();
            producto.setStock(stock);
            producto = productoRepository.save(producto);
            return productoMapper.toProductoResponseDto(producto);
        }catch (Exception e) {
            throw new InternalServerErrorException(
                    ErrorDTO.builder()
                            .error("Error General")
                            .message(e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .date(LocalDateTime.now())
                            .build()
            );
        }
    }

    private Producto findProductoBy(final Long id) throws RestException{
        return productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        ErrorDTO.builder()
                                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                                .message("No existe Producto")
                                .status(HttpStatus.NOT_FOUND.value())
                                .date(LocalDateTime.now())
                                .build())
                );
    }
}
