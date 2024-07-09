package co.edu.iudigital.app.domain.service.impl;

import co.edu.iudigital.app.domain.dto.proveedor.ProveedorRequestDTO;
import co.edu.iudigital.app.domain.dto.proveedor.ProveedorResponseDTO;
import co.edu.iudigital.app.domain.model.Proveedor;
import co.edu.iudigital.app.domain.repository.ProveedorRepository;
import co.edu.iudigital.app.domain.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainProveedorServiceImpl implements ProveedorService {// port

    // TODO: IMPLEMENTAR EXCEPCIONES PERSONALIZADAS
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorResponseDTO> getProveedores() { // TODO: colocar Mapper
        List<Proveedor> proveedores = proveedorRepository.findAll();
        return proveedores.stream().map(proveedor -> // lambdas de Java 8: programación funcional
                ProveedorResponseDTO.builder()
                        .id(proveedor.getId())
                        .nit(proveedor.getNit())
                        .nombre(proveedor.getNombre())
                        .direccion(proveedor.getDireccion())
                        .telefono(proveedor.getTelefono())
                        .paginaWeb(proveedor.getPaginaWeb())
                        .createdAt(proveedor.getCreatedAt())
                        .updatedAt(proveedor.getUpdatedAt())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public ProveedorResponseDTO createProveedor(ProveedorRequestDTO proveedorRequestDTO) { // TODO: colocar Mapper
        Proveedor proveedor = new Proveedor();

        proveedor.setNit(proveedorRequestDTO.getNit());
        proveedor.setNombre(proveedorRequestDTO.getNombre());
        proveedor.setDireccion(proveedorRequestDTO.getDireccion());
        proveedor.setTelefono(proveedorRequestDTO.getTelefono());
        proveedor.setPaginaWeb(proveedorRequestDTO.getPaginaWeb());

        proveedor = proveedorRepository.save(proveedor);

        // TODO: IMPLEMENTAR MAPSTRUCT
        return  ProveedorResponseDTO.builder()
                .id(proveedor.getId())
                .nit(proveedor.getNit())
                .nombre(proveedor.getNombre())
                .direccion(proveedor.getDireccion())
                .telefono(proveedor.getTelefono())
                .paginaWeb(proveedor.getPaginaWeb())
                .createdAt(proveedor.getCreatedAt())
                .updatedAt(proveedor.getUpdatedAt())
                .build();
    }

    @Override
    public ProveedorResponseDTO getProveedorById(Long id) { // TODO: colocar Mapper
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return  ProveedorResponseDTO.builder()
                .id(proveedor.getId())
                .nit(proveedor.getNit())
                .nombre(proveedor.getNombre())
                .direccion(proveedor.getDireccion())
                .telefono(proveedor.getTelefono())
                .paginaWeb(proveedor.getPaginaWeb())
                .createdAt(proveedor.getCreatedAt())
                .updatedAt(proveedor.getUpdatedAt())
                .build();
    }
}
