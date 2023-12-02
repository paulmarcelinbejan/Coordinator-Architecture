package io.github.paulmarcelinbejan.coordinator.architecture.service;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface ServiceInputAware<DOMAIN_INPUT> {

	void execute(DOMAIN_INPUT domain) throws FunctionalException, TechnicalException;
	
}
