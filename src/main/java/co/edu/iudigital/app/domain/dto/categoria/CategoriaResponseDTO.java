package co.edu.iudigital.app.domain.dto.categoria;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponseDTO implements Serializable {

    static final long serialVersionUID = 1L;

    Long id;
    String nombre;
    String descripcion;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
