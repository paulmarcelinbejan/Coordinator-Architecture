package io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface CoordinatorResponseAware<RESPONSE> {

	RESPONSE process() throws FunctionalException, TechnicalException;
	
}
