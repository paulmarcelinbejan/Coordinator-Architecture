package io.github.paulmarcelinbejan.coordinator.architecture.service;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

/**
 * An interface for services that execute domain logic producing domain output.
 *
 * @param <DOMAIN_OUTPUT> The type of the domain output.
 */
public interface ServiceOutputAware<DOMAIN_OUTPUT> {

    /**
     * Execute domain logic and produce domain output.
     *
     * @return The domain output after execution.
     * @throws FunctionalException If a functional error occurs during execution.
     * @throws TechnicalException  If a technical error occurs during execution.
     */
    DOMAIN_OUTPUT execute() throws FunctionalException, TechnicalException;

}
