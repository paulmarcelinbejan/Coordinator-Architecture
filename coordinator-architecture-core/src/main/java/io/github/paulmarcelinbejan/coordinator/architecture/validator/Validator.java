package io.github.paulmarcelinbejan.coordinator.architecture.validator;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

/**
 * An interface for validators that validate incoming requests.
 *
 * @param <REQUEST> The type of the incoming request.
 */
public interface Validator<REQUEST> {

    /**
     * Validate the incoming request.
     *
     * @param request The incoming request to be validated.
     * @throws FunctionalException If a functional error is detected during validation.
     * @throws TechnicalException  If a technical error occurs during validation.
     */
    void validate(REQUEST request) throws FunctionalException, TechnicalException;

}
