package com.paulmarcelinbejan.architecture.sniper.validator.id.impl;

import com.paulmarcelinbejan.architecture.sniper.validator.Validator;
import com.paulmarcelinbejan.architecture.sniper.validator.id.BaseIdValidator;

public interface IdValidator<
		ID extends Number & Comparable<? super ID>> 
		extends Validator<ID>, BaseIdValidator<ID> {

    @Override
    default void validate(ID id) {
        validateId(id);
    }
    
}