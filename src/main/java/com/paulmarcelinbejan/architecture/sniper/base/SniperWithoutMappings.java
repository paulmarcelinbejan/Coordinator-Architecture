package com.paulmarcelinbejan.architecture.sniper.base;

import com.paulmarcelinbejan.architecture.sniper.SniperRequestAware;
import com.paulmarcelinbejan.architecture.sniper.service.ServiceInputAware;
import com.paulmarcelinbejan.architecture.sniper.validator.Validator;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class SniperWithoutMappings<REQUEST> implements SniperRequestAware<REQUEST> {
	
	private final Validator<REQUEST> validator;
	
	private final ServiceInputAware<REQUEST> service;
	
	@Override
	public void fire(REQUEST request) throws FunctionalException, TechnicalException {
		
		// STEP 1: validate the request
		validator.validate(request);
		
		// STEP 3: execute domain logic
		service.execute(request);
		
	}

}
