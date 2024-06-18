package co.edu.iudigital.app.domain.dto.categoria;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("nombre")
    String nombre;

    @JsonProperty("descripcion")
    String descripcion;
}
