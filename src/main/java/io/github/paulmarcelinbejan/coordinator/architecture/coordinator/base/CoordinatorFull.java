package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;
import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CoordinatorFull<REQUEST, DOMAIN_INPUT, DOMAIN_OUTPUT, RESPONSE> implements CoordinatorRequestResponseAware<REQUEST, RESPONSE> {
	
	private final Validator<REQUEST> validator;
	
	private final MapperInput<REQUEST, DOMAIN_INPUT> mapperInput;
	
	private final ServiceInputOutputAware<DOMAIN_INPUT, DOMAIN_OUTPUT> service;
	
	private final MapperOutput<DOMAIN_OUTPUT, RESPONSE> mapperOutput;
	
	@Override
	public RESPONSE process(REQUEST request) throws FunctionalException, TechnicalException {
		
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
