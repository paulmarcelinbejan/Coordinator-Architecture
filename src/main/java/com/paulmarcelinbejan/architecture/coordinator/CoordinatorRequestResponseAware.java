package com.paulmarcelinbejan.architecture.coordinator;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface CoordinatorRequestResponseAware<REQUEST, RESPONSE> {

	RESPONSE process(REQUEST request) throws FunctionalException, TechnicalException;
	
}
