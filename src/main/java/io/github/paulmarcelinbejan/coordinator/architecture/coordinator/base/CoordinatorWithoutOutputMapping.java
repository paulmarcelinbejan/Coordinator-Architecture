package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
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
