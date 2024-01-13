package io.github.paulmarcelinbejan.coordinator.architecture.validator.id;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.Validator;

public interface IdValidator<
		ID extends Number & Comparable<? super ID>> 
		extends Validator<ID>, BaseIdValidator<ID> {

    @Override
    default void validate(ID id) {
        validateId(id);
    }
    
}