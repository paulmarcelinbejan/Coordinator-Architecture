package com.paulmarcelinbejan.architecture.coordinator.base;

import com.paulmarcelinbejan.architecture.coordinator.CoordinatorResponseAware;
import com.paulmarcelinbejan.architecture.coordinator.mapper.output.MapperOutput;
import com.paulmarcelinbejan.architecture.coordinator.service.ServiceOutputAware;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

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
