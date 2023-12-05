# Coordinator-Architecture
The Coordinator-Architecture enforces the use of Single-responsibility principle using Mediator Pattern with the aim of reducing coupling.

[![Maven Central](https://img.shields.io/maven-central/v/io.github.paulmarcelinbejan.architecture/coordinator-architecture.svg)](https://central.sonatype.com/artifact/io.github.paulmarcelinbejan.architecture/coordinator-architecture)
[![GitHub license](https://img.shields.io/github/license/Naereen/StrapDown.js.svg)](https://github.com/paulmarcelinbejan/Coordinator-Architecture/blob/develop/LICENSE.txt)

## How it works?
Using Coordinator-Architecture, each component will be responsible of only one task:
1. Validator : validate the request
2. MapperInput : maps request to domain input
3. Service : execute domain logic
4. MapperOutput : maps domain output to response.

The Coordinator component will process the request step-by-step with the help of the components above.

Coordinator is based on one of the three interfaces:

CoordinatorRequestResponseAware : will process the request and will return a response.
```java
public interface CoordinatorRequestResponseAware<REQUEST, RESPONSE> {

	RESPONSE process(REQUEST request) throws FunctionalException, TechnicalException;
	
}
```

CoordinatorRequestAware : will process the request and will not return any response.
```java
public interface CoordinatorRequestAware<REQUEST> {

    void process(REQUEST request) throws FunctionalException, TechnicalException;

}
```

CoordinatorResponseAware : will process the service logic and will return a response.
```java
public interface CoordinatorResponseAware<RESPONSE> {

	RESPONSE process() throws FunctionalException, TechnicalException;
	
}
```

To create a Coordinator component, you have to extend one of the following abstract implementation:

CoordinatorFull : implements CoordinatorRequestResponseAware and will process the request using Validator, MapperInput, ServiceInputOutputAware, MapperOutput
```java
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
```

CoordinatorServiceResponse : implements CoordinatorResponseAware and will process the service logic of ServiceOutputAware and will map the domain output to response using MapperOutput 
```java
@RequiredArgsConstructor
public abstract class CoordinatorServiceResponse<DOMAIN_OUTPUT, RESPONSE> implements CoordinatorResponseAware<RESPONSE> {
	
    private final ServiceOutputAware<DOMAIN_OUTPUT> service;

    private final MapperOutput<DOMAIN_OUTPUT, RESPONSE> mapperOutput;

    @Override
    public RESPONSE process() throws FunctionalException, TechnicalException {
		
        // STEP 1: execute domain logic
        DOMAIN_OUTPUT domainOutput = service.execute();
		
        // STEP 2: map domain object to response
        RESPONSE response = mapperOutput.toResponse(domainOutput);
		
        // STEP 3: return the response
        return response;
		
    }

}
```

CoordinatorWithoutInputMapping : implements CoordinatorRequestResponseAware and will process the request using Validator, ServiceInputOutputAware, MapperOutput
```java
@RequiredArgsConstructor
public abstract class CoordinatorWithoutInputMapping<REQUEST, DOMAIN_OUTPUT, RESPONSE> implements CoordinatorRequestResponseAware<REQUEST, RESPONSE> {
	
    private final Validator<REQUEST> validator;

    private final ServiceInputOutputAware<REQUEST, DOMAIN_OUTPUT> service;

    private final MapperOutput<DOMAIN_OUTPUT, RESPONSE> mapperOutput;

    @Override
    public RESPONSE process(REQUEST request) throws FunctionalException, TechnicalException {
		
        // STEP 1: validate the request
        validator.validate(request);
		
        // STEP 2: execute domain logic
        DOMAIN_OUTPUT domainOutput = service.execute(request);
		
        // STEP 3: map domain object to response
        RESPONSE response = mapperOutput.toResponse(domainOutput);
		
        // STEP 4: return the response
        return response;
		
    }
	
}
```

CoordinatorWithoutOutputMapping : implements CoordinatorRequestAware and will process the request using Validator, MapperInput, ServiceInputAware
```java
@RequiredArgsConstructor
public abstract class CoordinatorWithoutOutputMapping<REQUEST, DOMAIN_INPUT> implements CoordinatorRequestAware<REQUEST> {

    private final Validator<REQUEST> validator;

    private final MapperInput<REQUEST, DOMAIN_INPUT> mapperInput;

    private final ServiceInputAware<DOMAIN_INPUT> service;

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
```

CoordinatorWithoutMappings : implements CoordinatorRequestAware and will process the request using Validator, ServiceInputAware
```java
@RequiredArgsConstructor
public abstract class CoordinatorWithoutMappings<REQUEST> implements CoordinatorRequestAware<REQUEST> {

    private final Validator<REQUEST> validator;

    private final ServiceInputAware<REQUEST> service;

    @Override
    public void process(REQUEST request) throws FunctionalException, TechnicalException {
		
        // STEP 1: validate the request
        validator.validate(request);
		
        // STEP 2: execute domain logic
        service.execute(request);
		
    }

}
```

Validator will implement:
```java
public interface Validator<REQUEST> {

    void validate(REQUEST request) throws FunctionalException, TechnicalException;

}
```
or eventually JakartaBaseValidator/JakartaCollectionValidator that has a default implementation to validate the request using jakarta.validation.Validator

MapperInput will implement:
```java
public interface MapperInput<REQUEST, DOMAIN> {

    DOMAIN toDomain(REQUEST request) throws FunctionalException, TechnicalException;

}
```

MapperOutput will implement:
```java
public interface MapperOutput<DOMAIN, RESPONSE> {

    RESPONSE toResponse(DOMAIN domain);

}
```

Service will implement one of the following interfaces:

ServiceInputOutputAware:
```java
public interface ServiceInputOutputAware<DOMAIN_INPUT, DOMAIN_OUTPUT> {

    DOMAIN_OUTPUT execute(DOMAIN_INPUT domain) throws FunctionalException, TechnicalException;

}
```

ServiceInputAware:
```java
public interface ServiceInputAware<DOMAIN_INPUT> {

    void execute(DOMAIN_INPUT domain) throws FunctionalException, TechnicalException;

}
```

ServiceOutputAware:
```java
public interface ServiceOutputAware<DOMAIN_OUTPUT> {

    DOMAIN_OUTPUT execute() throws FunctionalException, TechnicalException;

}
```
