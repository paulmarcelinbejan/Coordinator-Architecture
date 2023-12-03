package io.github.paulmarcelinbejan.coordinator.architecture.service;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

/**
 * An interface for services that execute domain logic with domain input, producing domain output.
 *
 * @param <DOMAIN_INPUT>  The type of the domain input.
 * @param <DOMAIN_OUTPUT> The type of the domain output.
 */
public interface ServiceInputOutputAware<DOMAIN_INPUT, DOMAIN_OUTPUT> {

    /**
     * Execute domain logic with the provided domain input and produce domain output.
     *
     * @param domain The domain input.
     * @return The domain output after execution.
     * @throws FunctionalException If a functional error occurs during execution.
     * @throws TechnicalException  If a technical error occurs during execution.
     */
    DOMAIN_OUTPUT execute(DOMAIN_INPUT domain) throws FunctionalException, TechnicalException;

}
