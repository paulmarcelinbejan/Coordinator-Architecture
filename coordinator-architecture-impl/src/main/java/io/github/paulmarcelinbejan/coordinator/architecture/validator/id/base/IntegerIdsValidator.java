package io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.IdsValidator;

public interface IntegerIdsValidator extends IdsValidator<Integer, List<Integer>> {

	@Override
	default Integer getZeroValue() {
		return 0;
	}
	
}
