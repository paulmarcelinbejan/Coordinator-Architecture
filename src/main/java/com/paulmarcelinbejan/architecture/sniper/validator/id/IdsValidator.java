package com.paulmarcelinbejan.architecture.sniper.validator.id;

import java.util.Collection;

import com.paulmarcelinbejan.architecture.sniper.validator.Validator;

public interface IdsValidator<
		ID extends Number & Comparable<? super ID>, 
		REQUEST extends Collection<ID>> 
		extends Validator<REQUEST>,	BaseIdValidator<ID> {

    @Override
    default void validate(REQUEST ids) {
    	ids.forEach(this::validateId);
    }
    
}