package com.paulmarcelinbejan.architecture.coordinator.base;

import com.paulmarcelinbejan.architecture.coordinator.CoordinatorRequestAware;
import com.paulmarcelinbejan.architecture.coordinator.service.ServiceInputAware;
import com.paulmarcelinbejan.architecture.coordinator.validator.Validator;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CoordinatorWithoutMappings<REQUEST> implements CoordinatorRequestAware<REQUEST> {
	
	private final Validator<REQUEST> validator;
	
	private final ServiceInputAware<REQUEST> service;
	
	@Override
	public void process(REQUEST request) throws FunctionalException, TechnicalException {
		
		// STEP 1: validate the request
		validator.validate(request);
		
		// STEP 3: execute domain logic
		service.execute(request);
		
	}

}
