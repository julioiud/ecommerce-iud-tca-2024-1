package co.edu.iudigital.app.domain.service;

import co.edu.iudigital.app.domain.dto.proveedor.ProveedorRequestDTO;
import co.edu.iudigital.app.domain.dto.proveedor.ProveedorResponseDTO;

import java.util.List;

public interface ProveedorService {

    List<ProveedorResponseDTO> getProveedores();

    ProveedorResponseDTO createProveedor(ProveedorRequestDTO proveedor);

    ProveedorResponseDTO getProveedorById(Long id);
}
