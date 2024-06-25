package co.edu.iudigital.app.domain.dto.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductoRequestDTO implements Serializable { // TODO: IMPLEMENTAR VALIDATIONS

    static final long serialVersionUID = 1L;

    @NotNull
    String nombre;

    @JsonProperty("precio_unitario")
    BigDecimal precioUnitario;

    Integer stock;

    @JsonProperty("proveedor_id")
    Long proveedorId;

    @JsonProperty("categoria_id")
    Long categoriaId;
}
