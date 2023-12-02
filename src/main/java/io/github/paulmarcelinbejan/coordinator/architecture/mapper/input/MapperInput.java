package io.github.paulmarcelinbejan.coordinator.architecture.mapper.input;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface MapperInput<REQUEST, DOMAIN> {

	DOMAIN toDomain(REQUEST request) throws FunctionalException, TechnicalException;
	
}
