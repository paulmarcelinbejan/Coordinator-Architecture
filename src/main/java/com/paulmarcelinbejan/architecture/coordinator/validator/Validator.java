package com.paulmarcelinbejan.architecture.coordinator.validator;

public interface Validator<REQUEST> {
	
	public void validate(REQUEST request);
	
}
