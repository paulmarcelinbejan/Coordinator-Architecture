package io.github.paulmarcelinbejan.coordinator.architecture.validator.id;

import java.util.Collection;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;
import jakarta.validation.ValidationException;

public interface IdsValidator<
		ID extends Number & Comparable<? super ID>, 
		REQUEST extends Collection<ID>> 
		extends Validator<REQUEST>,	BaseIdValidator<ID> {

    @Override
    default void validate(REQUEST ids) {
        if (ids == null) {
            throw new ValidationException("ids can not be null.");
        }
    	ids.forEach(this::validateId);
    }
    
}