package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.processor.CoordinatorProcessor;
import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import lombok.RequiredArgsConstructor;

/**
 * A generic coordinator that coordinates 3 steps:
 * <ol>
 *   <li>validation of REQUEST</li>
 *   <li>mapping REQUEST to DOMAIN_INPUT</li>
 *   <li>execute domain logic</li>
 * </ol>
 * 
 * @param <REQUEST>      The type of the incoming request.
 * @param <DOMAIN_INPUT> The type of the domain input.
 */
@RequiredArgsConstructor
public abstract class CoordinatorWithoutOutputMapping<REQUEST, DOMAIN_INPUT> implements CoordinatorRequestAware<REQUEST> {
	
    /**
     * The validator responsible for validating the incoming request.
     */
    private final Validator<REQUEST> validator;

    /**
     * The mapper responsible for mapping the incoming request to the domain input.
     */
    private final MapperInput<REQUEST, DOMAIN_INPUT> mapperInput;

    /**
     * The service responsible for executing domain logic with the domain input and producing no explicit output.
     */
    private final ServiceInputAware<DOMAIN_INPUT> service;

    /**
     * Process the incoming request by validating, mapping to domain input, and executing domain logic.
     *
     * @param request The incoming request.
     * @throws FunctionalException If a functional error occurs during processing.
     * @throws TechnicalException  If a technical error occurs during processing.
     */
	@Override
	public void process(REQUEST request) throws FunctionalException, TechnicalException {
		
		CoordinatorProcessor.process(validator, mapperInput, service, request);
		
	}

}
