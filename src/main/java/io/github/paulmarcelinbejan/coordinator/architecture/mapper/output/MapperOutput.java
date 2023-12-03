package io.github.paulmarcelinbejan.coordinator.architecture.mapper.output;

/**
 * An interface for mappers that convert domain objects to responses.
 *
 * @param <DOMAIN>   The type of the domain object.
 * @param <RESPONSE> The type of the response.
 */
public interface MapperOutput<DOMAIN, RESPONSE> {

    /**
     * Convert the domain object to a response.
     *
     * @param domain The domain object.
     * @return The response after mapping.
     */
    RESPONSE toResponse(DOMAIN domain);

}
