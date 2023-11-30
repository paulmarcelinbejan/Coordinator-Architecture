package com.paulmarcelinbejan.architecture.sniper.validator.id.impl;

import java.util.Collection;

import com.paulmarcelinbejan.architecture.sniper.validator.Validator;
import com.paulmarcelinbejan.architecture.sniper.validator.id.BaseIdValidator;

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