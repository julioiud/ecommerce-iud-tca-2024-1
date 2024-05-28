package co.edu.iudigital.app.domain.dto.producto;

import co.edu.iudigital.app.domain.model.Categoria;
import co.edu.iudigital.app.domain.model.Proveedor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductoRequestDTO implements Serializable {

    static final long serialVersionUID = 1L;

    String nombre;

    @JsonProperty("precio_unitario")
    BigDecimal precioUnitario;

    Integer stock;
}
