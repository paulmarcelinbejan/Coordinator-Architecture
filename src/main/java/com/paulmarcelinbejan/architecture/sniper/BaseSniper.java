package com.paulmarcelinbejan.architecture.sniper;

import com.paulmarcelinbejan.architecture.sniper.exception.FunctionalException;
import com.paulmarcelinbejan.architecture.sniper.exception.TechnicalException;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;
import com.paulmarcelinbejan.architecture.sniper.service.Service;
import com.paulmarcelinbejan.architecture.sniper.validator.Validator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseSniper<REQUEST, DOMAIN_INPUT, DOMAIN_OUTPUT, RESPONSE> {

	private final Validator<REQUEST> validator;
	
	private final MapperInput<REQUEST, DOMAIN_INPUT> mapperInput;
	
	private final Service<DOMAIN_INPUT, DOMAIN_OUTPUT> service;
	
	private final MapperOutput<DOMAIN_OUTPUT, RESPONSE> mapperOutput;
	
	public RESPONSE fire(REQUEST request) throws FunctionalException, TechnicalException {
		// STEP 1: validate the request
		validate(request);
		
		// STEP 2: map request to domain object
		DOMAIN_INPUT domainInput = mapInput(request);
		
		// STEP 3: execute domain logic
		DOMAIN_OUTPUT domainOutput = execute(domainInput);
		
		// STEP 4: map domain object to response
		RESPONSE response = mapOutput(domainOutput);
		
		// STEP 5: return the response
		return response;
	}
	
	private void validate(REQUEST request) {
		validator.validate(request);
	}
	
	private DOMAIN_INPUT mapInput(REQUEST request) {
		DOMAIN_INPUT domainInput = mapperInput.toDomain(request);
		return domainInput;
	}
	
	private DOMAIN_OUTPUT execute(DOMAIN_INPUT domainInput) throws FunctionalException, TechnicalException {
		DOMAIN_OUTPUT domainOutput = service.execute(domainInput);
		return domainOutput;
	}
	
	private RESPONSE mapOutput(DOMAIN_OUTPUT domainOutput) {
		RESPONSE response = mapperOutput.toResponse(domainOutput);
		return response;
	}

}
