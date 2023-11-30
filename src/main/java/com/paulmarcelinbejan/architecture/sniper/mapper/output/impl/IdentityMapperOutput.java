package com.paulmarcelinbejan.architecture.sniper.mapper.output.impl;

import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;

public interface IdentityMapperOutput<T> extends MapperOutput<T, T> {

	@Override
	default T toResponse(T domain) {
		return domain;
	}
	
}
