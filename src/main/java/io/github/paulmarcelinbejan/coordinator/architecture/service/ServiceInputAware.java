package io.github.paulmarcelinbejan.coordinator.architecture.service;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

/**
 * An interface for services that execute domain logic with domain input.
 *
 * @param <DOMAIN_INPUT> The type of the domain input.
 */
public interface ServiceInputAware<DOMAIN_INPUT> {

    /**
     * Execute domain logic with the provided domain input.
     *
     * @param domain The domain input.
     * @throws FunctionalException If a functional error occurs during execution.
     * @throws TechnicalException  If a technical error occurs during execution.
     */
    void execute(DOMAIN_INPUT domain) throws FunctionalException, TechnicalException;

}
