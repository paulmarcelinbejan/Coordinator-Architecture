package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import lombok.RequiredArgsConstructor;

/**
 * A generic coordinator that coordinates 2 steps:
 * <ol>
 *   <li>validation of REQUEST</li>
 *   <li>execute domain logic</li>
 * </ol>
 * 
 * @param <REQUEST> The type of the incoming request.
 */
@RequiredArgsConstructor
public abstract class CoordinatorWithoutMappings<REQUEST> implements CoordinatorRequestAware<REQUEST> {
	
    /**
     * The validator responsible for validating the incoming request.
     */
    private final Validator<REQUEST> validator;

    /**
     * The service responsible for executing domain logic with the incoming request.
     */
    private final ServiceInputAware<REQUEST> service;

    /**
     * Process the incoming request by validating and executing domain logic.
     *
     * @param request The incoming request.
     * @throws FunctionalException If a functional error occurs during processing.
     * @throws TechnicalException  If a technical error occurs during processing.
     */
	@Override
	public void process(REQUEST request) throws FunctionalException, TechnicalException {
		
		// STEP 1: validate the request
		validator.validate(request);
		
		// STEP 2: execute domain logic
		service.execute(request);
		
	}

}
