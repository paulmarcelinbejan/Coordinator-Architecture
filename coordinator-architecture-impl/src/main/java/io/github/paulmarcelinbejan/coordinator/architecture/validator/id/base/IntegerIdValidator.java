package io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.IdValidator;

public interface IntegerIdValidator extends IdValidator<Integer> {

	@Override
	default Integer getZeroValue() {
		return 0;
	}
	
}
