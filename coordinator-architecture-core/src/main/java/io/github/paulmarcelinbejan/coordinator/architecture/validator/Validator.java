package io.github.paulmarcelinbejan.coordinator.architecture.validator;

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
     */
	void validate(REQUEST request);

}
