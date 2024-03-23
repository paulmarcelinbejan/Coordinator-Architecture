package io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;
import io.github.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;

/**
 * A Jakarta Base Validator interface that extends the generic Validator interface.
 *
 * @param <REQUEST> The type of the incoming request.
 */
public interface JakartaBaseValidator<REQUEST> extends Validator<REQUEST> {

    /**
     * Default implementation to delegate the validation to the ValidatorUtils class.
     *
     * @param request The incoming request to be validated.
     */
    @Override
	default void validate(REQUEST request) {
        ValidatorUtils.validate(request);
    }

}
