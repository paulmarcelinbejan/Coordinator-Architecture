package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable;

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
     * Process a service logic and produce a response.
     *
     * @return The response after processing.
     */
	RESPONSE process();
	
}
