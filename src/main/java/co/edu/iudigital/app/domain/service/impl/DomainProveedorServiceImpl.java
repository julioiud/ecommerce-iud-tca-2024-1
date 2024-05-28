package co.edu.iudigital.app.domain.service.impl;

import co.edu.iudigital.app.domain.model.Proveedor;
import co.edu.iudigital.app.domain.repository.ProveedorRepository;
import co.edu.iudigital.app.domain.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainProveedorServiceImpl implements ProveedorService {// port

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> getProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor createProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor getProveedorById(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
