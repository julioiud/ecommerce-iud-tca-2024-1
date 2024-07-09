package co.edu.iudigital.app.domain.dto.categoria;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequestDTO implements Serializable { // TODO: implementar validaciones

    static final long serialVersionUID = 1L;

    @NotNull(message = "Nombre Requerido")
    @JsonProperty("nombre")
    String nombre;

    @JsonProperty("descripcion")
    String descripcion;
}
