package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

/**
 * <p>
 * Interface for coordinators that are aware of the REQUEST to handle and the RESPONSE to return.
 * <br>This means that it is responsible to make sure that the incoming requests will be processed,
 * and to return the response.
 * </p>
 *
 * @param <REQUEST>  The type of the incoming request.
 * @param <RESPONSE> The type of the response.
 */
public interface CoordinatorRequestResponseAware<REQUEST, RESPONSE> {

    /**
     * Process the incoming request and produce a response.
     *
     * @param request The incoming request.
     * @return The response after processing the request.
     * @throws FunctionalException If a functional error occurs during processing.
     * @throws TechnicalException  If a technical error occurs during processing.
     */
	RESPONSE process(REQUEST request) throws FunctionalException, TechnicalException;
	
}
