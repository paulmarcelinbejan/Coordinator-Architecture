package io.github.paulmarcelinbejan.coordinator.architecture.service;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface ServiceOutputAware<DOMAIN_OUTPUT> {

	DOMAIN_OUTPUT execute() throws FunctionalException, TechnicalException;
	
}
