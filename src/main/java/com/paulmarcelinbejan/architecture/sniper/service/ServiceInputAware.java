package com.paulmarcelinbejan.architecture.sniper.service;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface ServiceInputAware<DOMAIN_INPUT> {

	void execute(DOMAIN_INPUT domain) throws FunctionalException, TechnicalException;
	
}
