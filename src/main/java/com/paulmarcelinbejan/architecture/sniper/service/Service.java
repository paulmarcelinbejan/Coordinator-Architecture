package com.paulmarcelinbejan.architecture.sniper.service;

import com.paulmarcelinbejan.architecture.sniper.exception.FunctionalException;
import com.paulmarcelinbejan.architecture.sniper.exception.TechnicalException;

public interface Service<DOMAIN_INPUT, DOMAIN_OUTPUT> {

	DOMAIN_OUTPUT execute(DOMAIN_INPUT domain) throws FunctionalException, TechnicalException;
	
}
