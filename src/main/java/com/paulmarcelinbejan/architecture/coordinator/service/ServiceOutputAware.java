package com.paulmarcelinbejan.architecture.coordinator.service;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface ServiceOutputAware<DOMAIN_OUTPUT> {

	DOMAIN_OUTPUT execute() throws FunctionalException, TechnicalException;
	
}