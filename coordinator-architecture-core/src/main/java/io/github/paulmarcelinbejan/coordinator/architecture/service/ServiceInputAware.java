package io.github.paulmarcelinbejan.coordinator.architecture.service;

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
     */
	void execute(DOMAIN_INPUT domain);

}
