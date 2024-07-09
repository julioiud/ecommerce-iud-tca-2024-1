package co.edu.iudigital.app.domain.exceptions;

import co.edu.iudigital.app.domain.dto.ErrorDTO;

/**
 * Exception de NotFound en el Rest
 * 
 */
public class NotFoundException extends RestException {

    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(ErrorDTO errorDto) {
        super(errorDto);
    }
}
