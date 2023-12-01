package com.paulmarcelinbejan.architecture.sniper;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SniperResponseAware<RESPONSE> {

	RESPONSE fire() throws FunctionalException, TechnicalException;
	
}
