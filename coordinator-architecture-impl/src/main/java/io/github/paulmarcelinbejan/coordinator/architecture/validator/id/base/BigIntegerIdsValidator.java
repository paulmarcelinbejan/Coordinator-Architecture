package io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base;

import java.math.BigInteger;
import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.IdsValidator;

public interface BigIntegerIdsValidator extends IdsValidator<BigInteger, List<BigInteger>> {

	@Override
	default BigInteger getZeroValue() {
		return BigInteger.ZERO;
	}
	
}
