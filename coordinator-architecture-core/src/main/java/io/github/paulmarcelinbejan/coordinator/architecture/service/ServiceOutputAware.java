package io.github.paulmarcelinbejan.coordinator.architecture.service;

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
     */
	DOMAIN_OUTPUT execute();

}
