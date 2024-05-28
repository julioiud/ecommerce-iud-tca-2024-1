package co.edu.iudigital.app.domain.service.impl;

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

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto createProducto(Producto producto) {
        Categoria categoria = categoriaRepository
                .findById(producto.getCategoria().getId())
                .orElseThrow(RuntimeException::new);
        Proveedor proveedor = proveedorRepository
                .findById(producto.getProveedor().getId())
                .orElseThrow(RuntimeException::new);
        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);
        return productoRepository.save(producto);
    }

    @Override
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto updateProductoById(Long id, Producto producto) {
        producto = productoRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return productoRepository.save(producto);
    }
}
