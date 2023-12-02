package com.paulmarcelinbejan.architecture.coordinator.mapper.input;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface MapperInput<REQUEST, DOMAIN> {

	DOMAIN toDomain(REQUEST request) throws FunctionalException, TechnicalException;
	
}
