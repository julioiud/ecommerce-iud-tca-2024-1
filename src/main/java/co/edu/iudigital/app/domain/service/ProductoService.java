package co.edu.iudigital.app.domain.service;

import co.edu.iudigital.app.domain.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getProductos();

    Producto createProducto(Producto producto);

    Producto getProductoById(Long id);

    void deleteById(Long id);

    Producto updateProductoById(Long id, Producto producto);
}
