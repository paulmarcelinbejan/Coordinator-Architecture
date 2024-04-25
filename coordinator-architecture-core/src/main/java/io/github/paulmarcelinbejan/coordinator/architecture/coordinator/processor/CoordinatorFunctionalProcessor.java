package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.processor;

import java.util.function.Consumer;
import java.util.function.Function;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoordinatorFunctionalProcessor {

	/**
     * Process the incoming request by validating, mapping, executing domain logic, and mapping the response.
     *
     * @param request The incoming request.
     * @return The response after processing the request.
     */
	public static <REQUEST,
				   DOMAIN_INPUT,
	   			   DOMAIN_OUTPUT,
	   			   RESPONSE> 
	RESPONSE process(Consumer<REQUEST> validator,
					 Function<REQUEST, DOMAIN_INPUT> mapperInput,
					 Function<DOMAIN_INPUT, DOMAIN_OUTPUT> service,
					 Function<DOMAIN_OUTPUT, RESPONSE> mapperOutput,
					 REQUEST request) {
	
		// STEP 1: validate the request
		validator.accept(request);
		
		// STEP 2: map request to domain object
		DOMAIN_INPUT domainInput = mapperInput.apply(request);
		
		// STEP 3: execute domain logic
		DOMAIN_OUTPUT domainOutput = service.apply(domainInput);
		
		// STEP 4: map domain object to response
		RESPONSE response = mapperOutput.apply(domainOutput);
		
		// STEP 5: return the response
		return response;
		
	}

    /**
     * Process the response by executing domain logic and mapping the domain output to the final response.
     *
     * @return The response after processing the response.
     */
	public static <REQUEST,
	   			   DOMAIN_OUTPUT,
	   			   RESPONSE> 
	RESPONSE process(Function<REQUEST, DOMAIN_OUTPUT> service,
				 	 Function<DOMAIN_OUTPUT, RESPONSE> mapperOutput,
				 	 REQUEST request) {
	
		// STEP 1: execute domain logic
		DOMAIN_OUTPUT domainOutput = service.apply(request);
		
		// STEP 2: map domain object to response
		RESPONSE response = mapperOutput.apply(domainOutput);
		
		// STEP 3: return the response
		return response;
		
	}

	/**
     * Process the incoming request by validating, executing domain logic, and mapping the response.
     *
     * @param request The incoming request.
     * @return The response after processing the request.
     */
	public static <REQUEST,
				   DOMAIN_OUTPUT,
				   RESPONSE> 
	RESPONSE process(Consumer<REQUEST> validator,
				 Function<REQUEST, DOMAIN_OUTPUT> service,
				 Function<DOMAIN_OUTPUT, RESPONSE> mapperOutput,
			 	 REQUEST request) {

		// STEP 1: validate the request
		validator.accept(request);
		
		// STEP 2: execute domain logic
		DOMAIN_OUTPUT domainOutput = service.apply(request);
	
		// STEP 3: map domain object to response
		RESPONSE response = mapperOutput.apply(domainOutput);
		
		// STEP 4: return the response
		return response;
				
	}
	
    /**
     * Process the incoming request by validating and executing domain logic.
     *
     * @param request The incoming request.
     */
	public static <REQUEST> 
	void process(Consumer<REQUEST> validator,
			 	 Consumer<REQUEST> service, 
			 	 REQUEST request) {

		// STEP 1: validate the request
		validator.accept(request);
		
		// STEP 2: execute domain logic
		service.accept(request);
	
	}

	/**
     * Process the incoming request by validating, mapping to domain input, and executing domain logic.
     *
     * @param request The incoming request.
     */
	public static <REQUEST, 
	   			   DOMAIN_INPUT> 
	void process(Consumer<REQUEST> validator,
				 Function<REQUEST, DOMAIN_INPUT> mapperInput, 
				 Consumer<DOMAIN_INPUT> service, 
				 REQUEST request) {
	
		// STEP 1: validate the request
		validator.accept(request);
		
		// STEP 2: map request to domain object
		DOMAIN_INPUT domainInput = mapperInput.apply(request);
		
		// STEP 3: execute domain logic
		service.accept(domainInput);
	
	}

}
