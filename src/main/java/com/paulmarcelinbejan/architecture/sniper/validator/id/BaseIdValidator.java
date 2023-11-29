package com.paulmarcelinbejan.architecture.sniper.validator.id;

import jakarta.validation.ValidationException;

public interface BaseIdValidator<ID extends Number & Comparable<? super ID>> {

    default void validateId(ID id) {
        if (id == null) {
            throw new ValidationException("Id can not be null.");
        }
        
        // Get a zero value of the appropriate type
        ID zero = getZeroValue();

        if (id.compareTo(zero) <= 0) {
            throw new ValidationException("Id must be greater than 0.");
        }
    }
    
    ID getZeroValue();
    
}