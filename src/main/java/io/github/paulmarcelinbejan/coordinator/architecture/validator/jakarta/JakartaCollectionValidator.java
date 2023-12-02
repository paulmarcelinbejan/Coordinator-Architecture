package io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta;

import java.util.Collection;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;
import io.github.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;

public interface JakartaCollectionValidator<TYPE_TO_VALIDATE, REQUEST extends Collection<TYPE_TO_VALIDATE>> extends Validator<REQUEST> {

	@Override
	public default void validate(REQUEST request) {
		ValidatorUtils.validateAll(request);
	}
	
}