package com.paulmarcelinbejan.architecture.coordinator;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface CoordinatorResponseAware<RESPONSE> {

	RESPONSE process() throws FunctionalException, TechnicalException;
	
}
