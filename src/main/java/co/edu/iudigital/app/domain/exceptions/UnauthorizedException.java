package co.edu.iudigital.app.domain.exceptions;

import co.edu.iudigital.app.domain.dto.ErrorDTO;

public class UnauthorizedException extends RestException {

    private static final long serialVersionUID = 1L;

    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(ErrorDTO errorDto) {
        super(errorDto);
    }
}
