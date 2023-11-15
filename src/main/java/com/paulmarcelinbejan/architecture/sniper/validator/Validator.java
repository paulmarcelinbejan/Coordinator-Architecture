package com.paulmarcelinbejan.architecture.sniper.validator;

public interface Validator<REQUEST> {
	
	public void validate(REQUEST request);
	
}
