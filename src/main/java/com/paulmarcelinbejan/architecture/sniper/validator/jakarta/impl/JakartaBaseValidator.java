package com.paulmarcelinbejan.architecture.sniper.validator.jakarta.impl;

import com.paulmarcelinbejan.architecture.sniper.validator.Validator;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;

public interface JakartaBaseValidator<REQUEST> extends Validator<REQUEST> {

	@Override
	public default void validate(REQUEST request) {
		ValidatorUtils.validate(request);
	}
	
}
