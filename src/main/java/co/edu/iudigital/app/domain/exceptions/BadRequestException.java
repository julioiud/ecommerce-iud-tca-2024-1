package co.edu.iudigital.app.domain.exceptions;

import co.edu.iudigital.app.domain.dto.ErrorDTO;

/**
 * Exception de BadRequest en el Rest
 *
 */
public class BadRequestException extends RestException {

    private static final long serialVersionUID = 1L;

    public BadRequestException() {
        super();
    }

    public BadRequestException(ErrorDTO errorDto) {
        super(errorDto);
    }

    public BadRequestException(String msg) {
        super(msg);
    }
}
