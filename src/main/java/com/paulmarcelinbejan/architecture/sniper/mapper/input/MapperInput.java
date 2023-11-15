package com.paulmarcelinbejan.architecture.sniper.mapper.input;

public interface MapperInput<REQUEST, DOMAIN> {

	DOMAIN toDomain(REQUEST request);
	
}
