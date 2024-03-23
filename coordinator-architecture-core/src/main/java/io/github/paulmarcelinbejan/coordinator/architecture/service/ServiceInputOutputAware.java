package io.github.paulmarcelinbejan.coordinator.architecture.service;

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
     */
	DOMAIN_OUTPUT execute(DOMAIN_INPUT domain);

}
