package com.paulmarcelinbejan.architecture.coordinator;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface CoordinatorRequestAware<REQUEST> {

	void process(REQUEST request) throws FunctionalException, TechnicalException;
	
}
