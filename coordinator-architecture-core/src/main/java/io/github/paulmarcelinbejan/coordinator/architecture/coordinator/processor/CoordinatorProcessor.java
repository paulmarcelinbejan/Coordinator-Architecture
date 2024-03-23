package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.processor;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;
import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceOutputAware;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoordinatorProcessor {

	/**
     * Process the incoming request by validating, mapping, executing domain logic, and mapping the response.
     *
     * @param request The incoming request.
     * @return The response after processing the request.
     */
	public static <VALIDATOR extends Validator<REQUEST>, 
				   MAPPER_INPUT extends MapperInput<REQUEST, DOMAIN_INPUT>, 
				   SERVICE extends ServiceInputOutputAware<DOMAIN_INPUT, DOMAIN_OUTPUT>, 
				   MAPPER_OUTPUT extends MapperOutput<DOMAIN_OUTPUT, RESPONSE>, 
				   REQUEST, 
				   DOMAIN_INPUT, 
				   DOMAIN_OUTPUT, 
				   RESPONSE> 
	RESPONSE process(VALIDATOR validator, 
					 MAPPER_INPUT mapperInput, 
					 SERVICE service, 
					 MAPPER_OUTPUT mapperOutput, 
					 REQUEST request) {
		
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
	
    /**
     * Process the response by executing domain logic and mapping the domain output to the final response.
     *
     * @return The response after processing the response.
     */
	public static <SERVICE extends ServiceOutputAware<DOMAIN_OUTPUT>, 
	   			   MAPPER_OUTPUT extends MapperOutput<DOMAIN_OUTPUT, RESPONSE>, 
	   			   DOMAIN_OUTPUT, 
	   			   RESPONSE> 
	RESPONSE process(SERVICE service, 
					 MAPPER_OUTPUT mapperOutput) {
		
		// STEP 1: execute domain logic
		DOMAIN_OUTPUT domainOutput = service.execute();
		
		// STEP 2: map domain object to response
		RESPONSE response = mapperOutput.toResponse(domainOutput);
		
		// STEP 3: return the response
		return response;
		
	}
	
    /**
     * Process the incoming request by validating, executing domain logic, and mapping the response.
     *
     * @param request The incoming request.
     * @return The response after processing the request.
     */
	public static <VALIDATOR extends Validator<REQUEST>, 
	   			   SERVICE extends ServiceInputOutputAware<REQUEST, DOMAIN_OUTPUT>, 
	   			   MAPPER_OUTPUT extends MapperOutput<DOMAIN_OUTPUT, RESPONSE>, 
	   			   REQUEST, 
	   			   DOMAIN_OUTPUT, 
	   			   RESPONSE> 
	RESPONSE process(VALIDATOR validator, 
					 SERVICE service, 
		             MAPPER_OUTPUT mapperOutput, 
		             REQUEST request) {
		
		// STEP 1: validate the request
		validator.validate(request);
		
		// STEP 2: execute domain logic
		DOMAIN_OUTPUT domainOutput = service.execute(request);
		
		// STEP 3: map domain object to response
		RESPONSE response = mapperOutput.toResponse(domainOutput);
		
		// STEP 4: return the response
		return response;
		
	}
	
    /**
     * Process the incoming request by validating and executing domain logic.
     *
     * @param request The incoming request.
     */
	public static <VALIDATOR extends Validator<REQUEST>,
	   			   SERVICE extends ServiceInputAware<REQUEST>, 
	   			   REQUEST> 
	void process(VALIDATOR validator, 
				 SERVICE service, 
				 REQUEST request) {
		
		// STEP 1: validate the request
		validator.validate(request);
		
		// STEP 2: execute domain logic
		service.execute(request);
		
	}
	
    /**
     * Process the incoming request by validating, mapping to domain input, and executing domain logic.
     *
     * @param request The incoming request.
     */
	public static <VALIDATOR extends Validator<REQUEST>, 
	   			   MAPPER_INPUT extends MapperInput<REQUEST, DOMAIN_INPUT>, 
	   			   SERVICE extends ServiceInputAware<DOMAIN_INPUT>, 
	   			   REQUEST, 
	   			   DOMAIN_INPUT> 
	void process(VALIDATOR validator, 
				 MAPPER_INPUT mapperInput, 
				 SERVICE service, 
				 REQUEST request) {
		
		// STEP 1: validate the request
		validator.validate(request);
		
		// STEP 2: map request to domain object
		DOMAIN_INPUT domainInput = mapperInput.toDomain(request);
		
		// STEP 3: execute domain logic
		service.execute(domainInput);
		
	}
	
}
