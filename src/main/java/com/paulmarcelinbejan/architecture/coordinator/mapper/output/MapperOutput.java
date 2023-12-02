package com.paulmarcelinbejan.architecture.coordinator.mapper.output;

public interface MapperOutput<DOMAIN, RESPONSE> {

	RESPONSE toResponse(DOMAIN domain);
	
}
