package co.edu.iudigital.app.domain.dto.producto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuyRequestDTO implements Serializable {

    static final long serialVersionUID = 1L;

    Integer quantity;
}
