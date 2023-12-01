package com.paulmarcelinbejan.architecture.sniper.base;

import com.paulmarcelinbejan.architecture.sniper.SniperRequestResponseAware;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;
import com.paulmarcelinbejan.architecture.sniper.service.ServiceInputOutputAware;
import com.paulmarcelinbejan.architecture.sniper.validator.Validator;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class SniperFull<REQUEST, DOMAIN_INPUT, DOMAIN_OUTPUT, RESPONSE> implements SniperRequestResponseAware<REQUEST, RESPONSE> {
	
	private final Validator<REQUEST> validator;
	
	private final MapperInput<REQUEST, DOMAIN_INPUT> mapperInput;
	
	private final ServiceInputOutputAware<DOMAIN_INPUT, DOMAIN_OUTPUT> service;
	
	private final MapperOutput<DOMAIN_OUTPUT, RESPONSE> mapperOutput;
	
	@Override
	public RESPONSE fire(REQUEST request) throws FunctionalException, TechnicalException {
		
		// STEP 1: validate the request
		validator.validate(request);
		
		// STEP 2: map request to domain object
		DOMAIN_INPUT domainInput = mapperInput.toDomain(request);
		
		// STEP 3: execute domain logic
		DOMAIN_OUTPUT domainOutput = service.execute(domainInput);
		
		// STEP 4: map domain object to response
		RESPONSE response = mapperOutput.toResponse(domainOutput);
		
		// STEP 5: return the response
		return response;
		
	}

}
