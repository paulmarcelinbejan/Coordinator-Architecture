package com.paulmarcelinbejan.architecture.sniper.base;

import com.paulmarcelinbejan.architecture.sniper.SniperResponseAware;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;
import com.paulmarcelinbejan.architecture.sniper.service.ServiceOutputAware;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class SniperServiceResponse<DOMAIN_OUTPUT, RESPONSE> implements SniperResponseAware<RESPONSE> {
	
	private final ServiceOutputAware<DOMAIN_OUTPUT> service;
	
	private final MapperOutput<DOMAIN_OUTPUT, RESPONSE> mapperOutput;
	
	@Override
	public RESPONSE fire() throws FunctionalException, TechnicalException {
		
		// STEP 1: execute domain logic
		DOMAIN_OUTPUT domainOutput = service.execute();
		
		// STEP 2: map domain object to response
		RESPONSE response = mapperOutput.toResponse(domainOutput);
		
		// STEP 3: return the response
		return response;
		
	}

}
