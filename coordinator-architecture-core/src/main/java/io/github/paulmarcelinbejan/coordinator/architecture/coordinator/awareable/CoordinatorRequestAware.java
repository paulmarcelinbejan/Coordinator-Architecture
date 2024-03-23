package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable;

/**
 * <p>
 * Interface for coordinators that are aware only of REQUEST.
 * <br>This means that it is responsible to make sure that the incoming requests will be processed,
 * and there is no response from service layer.
 * </p>
 *
 * @param <REQUEST> The type of the incoming request.
 */
public interface CoordinatorRequestAware<REQUEST> {

    /**
     * Process the incoming request.
     *
     * @param request The incoming request.
     */
	void process(REQUEST request);

}
