package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.processor.CoordinatorProcessor;
import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;

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
     */
	@Override
	public void process(REQUEST request) {
		
		CoordinatorProcessor.process(validator, service, request);
		
	}

}
