package com.paulmarcelinbejan.architecture.sniper.validator;

import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;

public interface BaseValidator<REQUEST> extends Validator<REQUEST> {

	@Override
	public default void validate(REQUEST request) {
		ValidatorUtils.validate(request);
	}
	
}
