package co.edu.iudigital.app.domain.dto.producto;

import co.edu.iudigital.app.domain.dto.categoria.CategoriaResponseDTO;
import co.edu.iudigital.app.domain.dto.proveedor.ProveedorResponseDTO;
import co.edu.iudigital.app.domain.model.Categoria;
import co.edu.iudigital.app.domain.model.Proveedor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponseDTO implements Serializable {

    static final long serialVersionUID = 1L;

    Long id;
    String nombre;

    @JsonProperty("precio_unitario")
    BigDecimal precioUnitario;

    Integer stock;

    @JsonProperty("created_at")
    LocalDateTime createdAt;

    @JsonProperty("updated_at")
    LocalDateTime updatedAt;

    ProveedorResponseDTO proveedor;

    CategoriaResponseDTO categoria;
}
