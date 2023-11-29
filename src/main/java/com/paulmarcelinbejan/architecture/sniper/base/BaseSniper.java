package com.paulmarcelinbejan.architecture.sniper.base;

import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;
import com.paulmarcelinbejan.architecture.sniper.service.Service;
import com.paulmarcelinbejan.architecture.sniper.validator.Validator;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

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
	
	private DOMAIN_INPUT mapInput(REQUEST request) throws FunctionalException, TechnicalException {
		return mapperInput.toDomain(request);
	}
	
	private DOMAIN_OUTPUT execute(DOMAIN_INPUT domainInput) throws FunctionalException, TechnicalException {
		return service.execute(domainInput);
	}
	
	private RESPONSE mapOutput(DOMAIN_OUTPUT domainOutput) {
		return mapperOutput.toResponse(domainOutput);
	}

}
