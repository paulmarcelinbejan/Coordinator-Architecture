package io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta;

import java.util.Collection;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;

/**
 * A Jakarta Collection Validator interface that extends the generic Validator interface for collections.
 *
 * @param <TYPE_TO_VALIDATE> The type of elements within the collection to be validated.
 * @param <REQUEST>          The type of the incoming collection request.
 */
public interface JakartaCollectionValidator<TYPE_TO_VALIDATE, REQUEST extends Collection<TYPE_TO_VALIDATE>>
        extends Validator<REQUEST> {

    /**
     * Default implementation to delegate the validation of all elements in the collection to the ValidatorUtils class.
     *
     * @param request The incoming collection request to be validated.
     * @throws FunctionalException If a functional error is detected during validation.
     * @throws TechnicalException  If a technical error occurs during validation.
     */
    @Override
    default void validate(REQUEST request) throws FunctionalException, TechnicalException {
        ValidatorUtils.validateAll(request);
    }

}
