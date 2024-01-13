package io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.IdValidator;

public interface LongIdValidator extends IdValidator<Long> {

	@Override
	default Long getZeroValue() {
		return 0L;
	}

}
