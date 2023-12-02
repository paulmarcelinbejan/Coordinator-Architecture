package io.github.paulmarcelinbejan.coordinator.architecture.validator;

public interface Validator<REQUEST> {
	
	public void validate(REQUEST request);
	
}
