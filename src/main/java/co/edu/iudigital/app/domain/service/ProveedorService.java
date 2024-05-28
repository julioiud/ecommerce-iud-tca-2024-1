package co.edu.iudigital.app.domain.service;

import co.edu.iudigital.app.domain.model.Proveedor;

import java.util.List;

public interface ProveedorService {

    List<Proveedor> getProveedores();

    Proveedor createProveedor(Proveedor proveedor);

    Proveedor getProveedorById(Long id);
}
