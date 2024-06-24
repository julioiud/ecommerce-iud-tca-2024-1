package co.edu.iudigital.app.domain.dto.proveedor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorRequestDTO implements Serializable { // TODO: implementar validaciones

    static final long serialVersionUID = 1L;

    String nit;

    String nombre;

    String direccion;

    String telefono;

    @JsonProperty("pagina_web")
    String paginaWeb;
}
