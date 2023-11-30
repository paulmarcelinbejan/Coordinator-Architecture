package com.paulmarcelinbejan.architecture.sniper.base;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface Sniper<REQUEST, RESPONSE> {

	RESPONSE fire(REQUEST request) throws FunctionalException, TechnicalException;
	
}
