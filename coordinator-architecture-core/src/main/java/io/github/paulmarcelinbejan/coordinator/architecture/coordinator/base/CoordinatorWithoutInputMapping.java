package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.processor.CoordinatorProcessor;
import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;
import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import lombok.RequiredArgsConstructor;

/**
 * A generic coordinator that coordinates 4 steps:
 * <ol>
 *   <li>validation of REQUEST</li>
 *   <li>execute domain logic</li>
 *   <li>mapping DOMAIN_OUTPUT to RESPONSE</li>
 *   <li>return RESPONSE</li>
 * </ol>
 * 
 * @param <REQUEST>      The type of the incoming request.
 * @param <DOMAIN_OUTPUT> The type of the domain output.
 * @param <RESPONSE>     The type of the response.
 */
@RequiredArgsConstructor
public abstract class CoordinatorWithoutInputMapping<REQUEST, DOMAIN_OUTPUT, RESPONSE> implements CoordinatorRequestResponseAware<REQUEST, RESPONSE> {
	
    /**
     * The validator responsible for validating the incoming request.
     */
    private final Validator<REQUEST> validator;

    /**
     * The service responsible for executing domain logic with the incoming request and producing domain output.
     */
    private final ServiceInputOutputAware<REQUEST, DOMAIN_OUTPUT> service;

    /**
     * The mapper responsible for mapping the domain output to the final response.
     */
    private final MapperOutput<DOMAIN_OUTPUT, RESPONSE> mapperOutput;

    /**
     * Process the incoming request by validating, executing domain logic, and mapping the response.
     *
     * @param request The incoming request.
     * @return The response after processing the request.
     * @throws FunctionalException If a functional error occurs during processing.
     * @throws TechnicalException  If a technical error occurs during processing.
     */
	@Override
	public RESPONSE process(REQUEST request) throws FunctionalException, TechnicalException {
		
		return CoordinatorProcessor.process(validator, service, mapperOutput, request);
		
	}
	
}
