package io.github.paulmarcelinbejan.coordinator.architecture.service;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface ServiceInputOutputAware<DOMAIN_INPUT, DOMAIN_OUTPUT> {

	DOMAIN_OUTPUT execute(DOMAIN_INPUT domain) throws FunctionalException, TechnicalException;
	
}
