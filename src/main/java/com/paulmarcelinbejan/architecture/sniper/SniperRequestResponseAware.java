package com.paulmarcelinbejan.architecture.sniper;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SniperRequestResponseAware<REQUEST, RESPONSE> {

	RESPONSE fire(REQUEST request) throws FunctionalException, TechnicalException;
	
}
