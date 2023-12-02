package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorResponseAware;
import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;
import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CoordinatorServiceResponse<DOMAIN_OUTPUT, RESPONSE> implements CoordinatorResponseAware<RESPONSE> {
	
	private final ServiceOutputAware<DOMAIN_OUTPUT> service;
	
	private final MapperOutput<DOMAIN_OUTPUT, RESPONSE> mapperOutput;
	
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
