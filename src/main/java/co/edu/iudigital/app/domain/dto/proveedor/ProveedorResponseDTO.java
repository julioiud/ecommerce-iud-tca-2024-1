package co.edu.iudigital.app.domain.dto.proveedor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorResponseDTO implements Serializable {

    static final long serialVersionUID = 1L;

    Long id;

    String nit;

    String nombre;

    String direccion;

    String telefono;

    @JsonProperty("pagina_web")
    String paginaWeb;

    @JsonProperty("created_at")
    LocalDateTime createdAt;

    @JsonProperty("updated_at")
    LocalDateTime updatedAt;
}
