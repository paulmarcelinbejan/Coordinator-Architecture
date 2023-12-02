package com.paulmarcelinbejan.architecture.coordinator.validator.jakarta.impl;

import com.paulmarcelinbejan.architecture.coordinator.validator.Validator;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;

public interface JakartaBaseValidator<REQUEST> extends Validator<REQUEST> {

	@Override
	public default void validate(REQUEST request) {
		ValidatorUtils.validate(request);
	}
	
}
