package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorResponseAware;
import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;
import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import lombok.RequiredArgsConstructor;

/**
 * A generic coordinator that coordinates 3 steps:
 * <ol>
 *   <li>execute domain logic</li>
 *   <li>mapping DOMAIN_OUTPUT to RESPONSE</li>
 *   <li>return RESPONSE</li>
 * </ol>
 * 
 * @param <DOMAIN_OUTPUT> 	The type of the domain output.
 * @param <RESPONSE>     	The type of the response.
 */
@RequiredArgsConstructor
public abstract class CoordinatorServiceResponse<DOMAIN_OUTPUT, RESPONSE> implements CoordinatorResponseAware<RESPONSE> {
	
    /**
     * The service responsible for executing domain logic and producing domain output.
     */
    private final ServiceOutputAware<DOMAIN_OUTPUT> service;

    /**
     * The mapper responsible for mapping the domain output to the final response.
     */
    private final MapperOutput<DOMAIN_OUTPUT, RESPONSE> mapperOutput;

    /**
     * Process the response by executing domain logic and mapping the domain output to the final response.
     *
     * @return The response after processing the response.
     * @throws FunctionalException If a functional error occurs during processing.
     * @throws TechnicalException  If a technical error occurs during processing.
     */
	@Override
	public RESPONSE process() throws FunctionalException, TechnicalException {
		
		// STEP 1: execute domain logic
		DOMAIN_OUTPUT domainOutput = service.execute();
		
		// STEP 2: map domain object to response
		RESPONSE response = mapperOutput.toResponse(domainOutput);
		
		// STEP 3: return the response
		return response;
		
	}

}
