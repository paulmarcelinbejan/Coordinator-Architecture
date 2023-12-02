package io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;
import io.github.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;

public interface JakartaBaseValidator<REQUEST> extends Validator<REQUEST> {

	@Override
	public default void validate(REQUEST request) {
		ValidatorUtils.validate(request);
	}
	
}
