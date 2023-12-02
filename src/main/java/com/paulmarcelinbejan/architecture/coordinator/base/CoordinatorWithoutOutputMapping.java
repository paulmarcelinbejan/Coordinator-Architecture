package com.paulmarcelinbejan.architecture.coordinator.base;

import com.paulmarcelinbejan.architecture.coordinator.CoordinatorRequestAware;
import com.paulmarcelinbejan.architecture.coordinator.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.coordinator.service.ServiceInputOutputAware;
import com.paulmarcelinbejan.architecture.coordinator.validator.Validator;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CoordinatorWithoutOutputMapping<REQUEST, DOMAIN_INPUT> implements CoordinatorRequestAware<REQUEST> {
	
	private final Validator<REQUEST> validator;
	
	private final MapperInput<REQUEST, DOMAIN_INPUT> mapperInput;
	
	private final ServiceInputOutputAware<DOMAIN_INPUT, Void> service;
	
	@Override
	public void process(REQUEST request) throws FunctionalException, TechnicalException {
		
		// STEP 1: validate the request
		validator.validate(request);
		
		// STEP 2: map request to domain object
		DOMAIN_INPUT domainInput = mapperInput.toDomain(request);
		
		// STEP 3: execute domain logic
		service.execute(domainInput);
		
	}

}
