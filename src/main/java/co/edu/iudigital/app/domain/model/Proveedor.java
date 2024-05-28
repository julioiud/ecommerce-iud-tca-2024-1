package co.edu.iudigital.app.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Proveedor implements Serializable {

    static final long serialVersionUID = 1L;

    Long id;
    String nit;
    String nombre;
    String direccion;
    String telefono;
    String paginaWeb;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
