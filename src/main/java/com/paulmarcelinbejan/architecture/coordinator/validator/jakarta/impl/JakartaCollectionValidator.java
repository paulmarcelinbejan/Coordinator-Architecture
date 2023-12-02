package com.paulmarcelinbejan.architecture.coordinator.validator.jakarta.impl;

import java.util.Collection;

import com.paulmarcelinbejan.architecture.coordinator.validator.Validator;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;

public interface JakartaCollectionValidator<TYPE_TO_VALIDATE, REQUEST extends Collection<TYPE_TO_VALIDATE>> extends Validator<REQUEST> {

	@Override
	public default void validate(REQUEST request) {
		ValidatorUtils.validateAll(request);
	}
	
}