package com.paulmarcelinbejan.architecture.sniper.validator;

import java.util.Collection;

import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;

public interface CollectionValidator<TYPE_TO_VALIDATE, REQUEST extends Collection<TYPE_TO_VALIDATE>> extends Validator<REQUEST> {

	@Override
	public default void validate(REQUEST request) {
		ValidatorUtils.validateAll(request);
	}
	
}