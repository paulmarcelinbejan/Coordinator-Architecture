package com.paulmarcelinbejan.architecture.sniper.mapper.input.impl;

import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;

public interface IdentityMapperInput<T> extends MapperInput<T, T> {

	@Override
	default T toDomain(T request) {
		return request;
	}
	
}
