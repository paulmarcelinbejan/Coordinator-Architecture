package com.paulmarcelinbejan.architecture.sniper.service;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface Service<DOMAIN_INPUT, DOMAIN_OUTPUT> {

	DOMAIN_OUTPUT execute(DOMAIN_INPUT domain) throws FunctionalException, TechnicalException;
	
}
