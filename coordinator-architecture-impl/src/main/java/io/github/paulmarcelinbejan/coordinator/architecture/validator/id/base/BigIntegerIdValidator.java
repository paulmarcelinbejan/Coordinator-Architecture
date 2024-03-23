package io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base;

import java.math.BigInteger;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.IdValidator;

public interface BigIntegerIdValidator extends IdValidator<BigInteger> {

	@Override
	default BigInteger getZeroValue() {
		return BigInteger.ZERO;
	}
	
}
