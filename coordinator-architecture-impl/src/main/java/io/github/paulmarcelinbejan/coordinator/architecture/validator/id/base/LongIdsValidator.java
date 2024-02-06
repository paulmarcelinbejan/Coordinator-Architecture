package io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.IdsValidator;

public interface LongIdsValidator extends IdsValidator<Long, List<Long>> {

	@Override
	default Long getZeroValue() {
		return 0L;
	}
	
}
