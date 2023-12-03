package io.github.paulmarcelinbejan.coordinator.architecture.mapper.input;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

/**
 * An interface for mappers that convert incoming requests to domain objects.
 *
 * @param <REQUEST> The type of the incoming request.
 * @param <DOMAIN>  The type of the domain object.
 */
public interface MapperInput<REQUEST, DOMAIN> {

    /**
     * Convert the incoming request to a domain object.
     *
     * @param request The incoming request.
     * @return The domain object after mapping.
     * @throws FunctionalException If a functional error occurs during mapping.
     * @throws TechnicalException  If a technical error occurs during mapping.
     */
    DOMAIN toDomain(REQUEST request) throws FunctionalException, TechnicalException;

}
