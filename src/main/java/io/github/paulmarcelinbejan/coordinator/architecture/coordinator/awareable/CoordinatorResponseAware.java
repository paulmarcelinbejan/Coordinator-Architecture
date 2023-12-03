package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

/**
 * <p>
 * Interface for coordinators that are aware only of RESPONSE.
 * <br>This means that it is responsible to execute the service layer, and return a response
 * </p>
 *
 * @param <RESPONSE> The type of the response.
 */
public interface CoordinatorResponseAware<RESPONSE> {

    /**
     * Process the response.
     *
     * @return The response after processing.
     * @throws FunctionalException If a functional error occurs during processing.
     * @throws TechnicalException  If a technical error occurs during processing.
     */
	RESPONSE process() throws FunctionalException, TechnicalException;
	
}
